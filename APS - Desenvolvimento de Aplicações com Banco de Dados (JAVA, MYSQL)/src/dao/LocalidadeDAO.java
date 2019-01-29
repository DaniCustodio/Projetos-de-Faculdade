/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Conexao;
import entidade.Localidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class LocalidadeDAO {
    Connection conn;
    
    public LocalidadeDAO(){
        conn = new Conexao().getConexao();
    }
    
    public void popularJComboBox(JComboBox comboBox){
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM localidade");
            ResultSet rs = pstmt.executeQuery();
            comboBox.removeAllItems();
            while(rs.next()){
                int cod = rs.getInt("codLocal");
                String nome = rs.getString("nome");
                String end = rs.getString("endereco");
                String tel = rs.getString("telefone");
                
                Localidade l = new Localidade(cod, nome, end, tel);
                comboBox.addItem(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
