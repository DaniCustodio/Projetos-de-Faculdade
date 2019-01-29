/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;


import java.sql.Connection;
import java.sql.DriverManager;
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
public class Conexao {
    private String DRIVER_CLASS;
    private String URL_MYSQL;
    private String LOGIN;
    private String SENHA;

    public Conexao(){
        this.DRIVER_CLASS = "com.mysql.jdbc.Driver";        
        this.URL_MYSQL = "jdbc:mysql://localhost:3306/apsvenda";
        this.LOGIN = "root";
        this.SENHA = null;
    }
    
    public Connection getConexao(){
        Connection conn = null;
        try {Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(URL_MYSQL, LOGIN, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }


    
    
}

