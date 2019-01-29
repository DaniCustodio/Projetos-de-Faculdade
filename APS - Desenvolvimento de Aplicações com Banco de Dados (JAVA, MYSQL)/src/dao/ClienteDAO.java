/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cliente;
import entidade.Conexao;
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
public class ClienteDAO{
    Connection conn;
    
    public ClienteDAO(){
        conn = new Conexao().getConexao();
    }
    
    public ArrayList listarTodos() {
        ArrayList<Cliente> lista= new ArrayList<>();       
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int cod = rs.getInt("codCli");
                String nome = rs.getString("nome");
                int bonus = rs.getInt("bonus");
                String perfil = rs.getString("perfil");
                String status = rs.getString("status");
                
                Cliente c = new Cliente(cod, nome, bonus, perfil, status);
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void popularJComboBox(JComboBox comboBox){
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = pstmt.executeQuery();
            comboBox.removeAllItems();
            while(rs.next()){
                int cod = rs.getInt("codCli");
                String nome = rs.getString("nome");
                int bonus = rs.getInt("bonus");
                String perfil = rs.getString("perfil");
                String status = rs.getString("status");
                
                Cliente c = new Cliente(cod, nome, bonus, perfil, status);
                comboBox.addItem(c);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
