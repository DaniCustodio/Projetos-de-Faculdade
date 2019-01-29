/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class DescontoDAO {
    Connection conn;
    
    public DescontoDAO() {
        this.conn = new Conexao().getConexao();
    }
    
    public Double calcularDesconto(int codProduto, int codCliente, int qtd, double total){
        int bonus = 0;
        double totalComDesconto = total;
        try {
            //Consulta o banco e recupera o bonus do cliente informado
            PreparedStatement pstmt = conn.prepareStatement("SELECT bonus "
                    + "FROM cliente WHERE codCli = ?");
            pstmt.setInt(1, codCliente);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                bonus = rs.getInt("bonus");
            }
            //Verifica se o cliente tem o valor minimo de bonus para aplicar o desconto
            if(bonus >= 100){
                int percentualDesconto = 0;
                //Consulta o banco e recupera o valor do percentual de desconto para um dado produto
                PreparedStatement dstmt = conn.prepareStatement("SELECT percentual "
                        + "FROM desconto "
                        + "WHERE codProd = ? AND qtd_min <= ? AND qtd_max >= ?");
                dstmt.setInt(1, codProduto);
                dstmt.setInt(2, qtd);
                dstmt.setInt(3, qtd);
                ResultSet drs = dstmt.executeQuery(); //Possivel problema! Não existir desconto para o produto especificado
                while (drs.next()) {
                    percentualDesconto = drs.getInt("percentual");
                }
                if(percentualDesconto != 0){
                    //Calcula o valor total com desconto
                    totalComDesconto = total - (total * percentualDesconto/100);

                    //Atualiza o saldo de bonus do cliente
                    dstmt = conn.prepareStatement("UPDATE cliente "
                            + "SET bonus = bonus - 100 WHERE codCli = ?");
                    dstmt.setInt(1, codCliente);
                    int udrs = dstmt.executeUpdate();
                }else{
                    totalComDesconto = total;
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DescontoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*/Formata para 2 casas decimais e retorna o valor total com desconto
        double scale = Math.pow(10, 2);
        return Math.round(totalComDesconto * scale) / scale;*/
        return totalComDesconto;
    }
    
}
