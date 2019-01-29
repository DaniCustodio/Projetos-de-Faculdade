/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Conexao;
import excecoes.EstoqueInsuficienteException;
import excecoes.QuantidadeInsuficienteException;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class VendaDAO {
    private Connection conn;
    private JFrame jFrame;
    public VendaDAO(JFrame jframe) {
        conn = new Conexao().getConexao();
        jFrame = jframe;
    }

    public VendaDAO() {
        conn = new Conexao().getConexao();
    }
    
    public void incluirVenda(int codCli, int codProd, int codLocal, int quantidade){

        PreparedStatement pstmt;
        double precoUnitarioProduto = 0.0;
        int localProduto = 0;     
        double valorTotal = 0;
        try {conn.setAutoCommit(false);
            try{
                if(quantidade <= 0){
                    throw new QuantidadeInsuficienteException("Quantidade Inválida");
                }
                //TRATAR ESTOQUE E A EXISTÊNCIA DO PRODUTO
                String querySelectProduto = "SELECT descricao, codLocal, qtd_estoque, preco_unitario "
                        + "FROM produto WHERE codProd = ?";
                pstmt = conn.prepareStatement(querySelectProduto);
                pstmt.setInt(1, codProd);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    if(rs.getInt("qtd_estoque") < quantidade){
                        EstoqueInsuficienteException ex;
                        ex = new EstoqueInsuficienteException("Produto sem estoque!");
                        throw ex;
                    }
                    precoUnitarioProduto = rs.getDouble("preco_unitario");
                    localProduto = rs.getInt("codLocal");
                }
                String updateEstoque = "UPDATE produto SET qtd_estoque = qtd_estoque - ? "
                        + "WHERE codProd = ?";
                pstmt = conn.prepareStatement(updateEstoque);
                pstmt.setInt(1, quantidade);
                pstmt.setInt(2, codProd);
                int rsUpEstoque = pstmt.executeUpdate();
                
                //*** CALCULAR O PREÇO TOTAL ***
                valorTotal = valorTotal + (quantidade * precoUnitarioProduto);
                
                //*** CALCULAR DESCONTO 1
                valorTotal = 
                        new DescontoDAO().calcularDesconto(codProd, codCli, quantidade, valorTotal);
                
                //*** CALCULAR DESCONTO 2
                if(codLocal == localProduto){
                    valorTotal = valorTotal - (valorTotal * 10/100);
                }
                //Verificar se a venda existe, se existir exclui a venda
                if(vendaExiste(codCli, codProd, codLocal)){
                    excluirVenda(codCli, codProd, codLocal);
                    conn = new Conexao().getConexao(); //reinicia a conexão
                    conn.setAutoCommit(false); //redesliga o autocommit
                }
                //*** GRAVAR VENDA ***
                String upGravarVenda = "INSERT INTO venda"
                    + "(codCli, codProd, codLocal, qtd_venda, valor_total, "
                    + "data_venda) VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(upGravarVenda);
                pstmt.setInt(1, codCli);
                pstmt.setInt(2, codProd);
                pstmt.setInt(3, codLocal);
                pstmt.setInt(4, quantidade);
                pstmt.setDouble(5, valorTotal);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                pstmt.setString(6, dateFormat.format(date));
                int rsUpGravar = pstmt.executeUpdate();
                if(rsUpGravar == 1){
                    conn.commit();
                    System.out.println("Venda incluida com sucesso!");
                }else{
                    SQLException erroSave = new SQLException("Erro na gravação da venda!");
                    throw erroSave;
                }
            }catch(EstoqueInsuficienteException e){
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(jFrame, e.getMessage());
            } catch(Exception e){
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, e);
                conn.rollback();
                JOptionPane.showMessageDialog(jFrame, e.getMessage());
            } finally{
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(jFrame, ex.getMessage());
        }
    }

    public void excluirVenda(int codCli, int codProd, int codLocal) {
        
        try{conn.setAutoCommit(false);
            try {
                //***BUSCAR VENDA***
                Venda venda = new Venda();
                String queryBuscarVenda = "SELECT * FROM venda WHERE codCli = ? AND codProd = ? AND codLocal = ?";
                PreparedStatement stmtBuscarVenda = conn.prepareStatement(queryBuscarVenda);
                stmtBuscarVenda.setInt(1, codCli);
                stmtBuscarVenda.setInt(2,codProd);
                stmtBuscarVenda.setInt(3, codLocal);
                ResultSet rsBuscarVenda = stmtBuscarVenda.executeQuery();
                while(rsBuscarVenda.next()){
                    venda.setCodCliente(rsBuscarVenda.getInt("codCli"));
                    venda.setCodProduto(rsBuscarVenda.getInt("codProd"));
                    venda.setCodLocalidade(rsBuscarVenda.getInt("codLocal"));
                    venda.setQtdVenda(rsBuscarVenda.getInt("qtd_venda"));
                    venda.setValorTotal(rsBuscarVenda.getDouble("valor_total"));
                    venda.setDataVenda(rsBuscarVenda.getDate("data_venda"));
                }
              
                //**** TRATAR ESTOQUE ***
                PreparedStatement pstmt = conn.prepareStatement("UPDATE produto "
                        + "SET qtd_estoque = qtd_estoque + ? "
                        + "WHERE codProd = ?");
                pstmt.setInt(1, venda.getQtdVenda());
                pstmt.setInt(2, venda.getCodProduto());
                int uprs = pstmt.executeUpdate();
                
                //**** DEVOLVER BONUS DO CLIENTE ***                
                double precoUni = 0;
                int codLocalProduto = 0;
                PreparedStatement stmtDevolverBonus;
                
                //Consulta o banco e recupera o preço_unitário e codLocal do produto
                String queryProduto = "SELECT preco_unitario, codLocal FROM produto WHERE codProd = ?";
                stmtDevolverBonus = conn.prepareStatement(queryProduto);
                stmtDevolverBonus.setInt(1, venda.getCodProduto());
                ResultSet rsDevolverBonus = stmtDevolverBonus.executeQuery();
                while(rsDevolverBonus.next()){
                    precoUni = rsDevolverBonus.getDouble("preco_unitario");
                    codLocalProduto = rsDevolverBonus.getInt("codLocal");
                }
                
                //Verfica se o cliente recebeu o desconto 2 (Desconto referente a localidade)
                double valorTotalReal = precoUni * venda.getQtdVenda();
                double valorTotal = venda.getValorTotal();
                if(venda.getCodLocalidade() == codLocalProduto){
                    double valorDescLocal = valorTotalReal * 0.10;
                    valorTotal =  valorTotal + valorDescLocal;
                }
                
                //Atualiza o cliente, devolvendo seu bonus
                String updateCliente = "UPDATE cliente SET bonus = bonus + 100 WHERE codCli = ? AND ? < ?";
                stmtDevolverBonus = conn.prepareStatement(updateCliente);
                stmtDevolverBonus.setInt(1, venda.getCodCliente());
                stmtDevolverBonus.setDouble(2, valorTotal);
                stmtDevolverBonus.setDouble(3, valorTotalReal);
                int upDevolverBonus = stmtDevolverBonus.executeUpdate();
                
                //*** DELETAR A VENDA ***
                PreparedStatement stmtDeletarVenda;
                String deleteVenda = "DELETE FROM venda WHERE codCli = ? AND codProd = ? AND codLocal = ?";
                stmtDeletarVenda = conn.prepareStatement(deleteVenda);
                stmtDeletarVenda.setInt(1, venda.getCodCliente());
                stmtDeletarVenda.setInt(2, venda.getCodProduto());
                stmtDeletarVenda.setInt(3, venda.getCodLocalidade());
                int upDeletarVenda = stmtDeletarVenda.executeUpdate();
                if(upDeletarVenda == 1){
                    System.out.println("Venda excluída com sucesso!");
                    conn.commit();
                }else{
                    SQLException falhaExclusao = new SQLException("Venda não excluída");
                    throw falhaExclusao;
                }           
            } catch (SQLException ex) {
                conn.rollback();
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(jFrame, ex.getMessage());
            } catch (Exception e) {
                conn.rollback();
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(jFrame, e.getMessage());
            }finally{
                conn.setAutoCommit(true);
                conn.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(jFrame, ex.getMessage());
        }
    }
    
    public List listar(){
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM venda");           
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){ 
                Venda v = new Venda();
                v.setCodCliente(rs.getInt("codCli"));
                v.setCodLocalidade(rs.getInt("codLocal"));
                v.setCodProduto(rs.getInt("codProd"));
                v.setQtdVenda(rs.getInt("qtd_venda"));
                v.setValorTotal(rs.getDouble("valor_total"));
                v.setDataVenda(rs.getDate("data_venda"));
                
                lista.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    //Listar vendas baseadas no cliente e no local em que foram feitas
    public void listar(DefaultTableModel jTable, int codCli, int codLocal){
        try{
            PreparedStatement stmtListar;
            String sqlQuery = "SELECT produto.descricao, produto.preco_unitario,"
                    + " venda.qtd_venda, venda.valor_total, venda.codProd "
                    + "FROM venda "
                    + "JOIN produto ON venda.codProd = produto.codProd "
                    + "JOIN cliente ON cliente.codCli = venda.codCli WHERE venda.codCli = ? AND venda.codLocal = ?";
            stmtListar = conn.prepareStatement(sqlQuery);
            stmtListar.setInt(1, codCli);
            stmtListar.setInt(2, codLocal);
            ResultSet rsListar = stmtListar.executeQuery();
            jTable.setNumRows(0);
            while (rsListar.next()) {
                jTable.addRow(new Object[]{rsListar.getInt("codProd"), rsListar.getString("descricao"),
                    rsListar.getInt("qtd_venda"), rsListar.getDouble("preco_unitario"),
                    rsListar.getDouble("valor_total")});
            }
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    //Verficar se uma venda já foi feita
    public boolean vendaExiste(int codCli, int codProd, int codLocal) throws SQLException{
        boolean var = false;
        String querySelVenda = "SELECT * FROM venda WHERE codCli = ? AND codProd = ? AND codLocal = ?";
        PreparedStatement stmtSelVenda = conn.prepareStatement(querySelVenda);
        stmtSelVenda.setInt(1, codCli);
        stmtSelVenda.setInt(2, codProd);
        stmtSelVenda.setInt(3, codLocal);        
        ResultSet rsSelVenda = stmtSelVenda.executeQuery();
        if(rsSelVenda.next()){
            var = true;
        }
        return var;
    }
}
