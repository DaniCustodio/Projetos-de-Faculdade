/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Conexao;
import entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class ProdutoDAO{
    Connection conn;

    public ProdutoDAO() {
        this.conn = new Conexao().getConexao();
    }
    
    public List listarTodos() {
        List<Produto> lista= new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM produto");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int cod = rs.getInt("codProd");
                int codLocal = rs.getInt("codLocal");
                String desc = rs.getString("descricao");               
                int qtdEst = rs.getInt("qtd_estoque");
                double precoUnitario = rs.getDouble("preco_unitario");
                
                Produto p = new Produto(cod, codLocal, desc, qtdEst, precoUnitario);
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void popularJComboBox(JComboBox comboBox){
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM produto");
            ResultSet rs = pstmt.executeQuery();
            comboBox.removeAllItems();
            while(rs.next()){
                int cod = rs.getInt("codProd");
                int codLocal = rs.getInt("codLocal");
                String desc = rs.getString("descricao");               
                int qtdEst = rs.getInt("qtd_estoque");
                double precoUnitario = rs.getDouble("preco_unitario");
                
                Produto p = new Produto(cod, codLocal, desc, qtdEst, precoUnitario);
                comboBox.addItem(p);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Produto pesquisar(String descricao){
        Produto produto = new Produto();
        String queryPesquisa = "SELECT * FROM produto WHERE descricao LIKE ? ";
        try {
            PreparedStatement stmtPesquisa = conn.prepareStatement(queryPesquisa);
            stmtPesquisa.setString(1, "%" + descricao + "%");
            ResultSet rsPesquisa = stmtPesquisa.executeQuery();
            while(rsPesquisa.next()){
                produto.setCodProduto(rsPesquisa.getInt("codProd"));
                produto.setDescricao(rsPesquisa.getString("descricao"));
                produto.setCodLocal(rsPesquisa.getInt("codLocal"));
                produto.setPrecoUnitario(rsPesquisa.getDouble("preco_unitario"));
                produto.setQtdEstoque(rsPesquisa.getInt("qtd_estoque"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
