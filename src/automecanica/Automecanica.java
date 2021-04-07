/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automecanica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import tela.LoginFrm;
import tela.MainFrm;

/**
 *
 * @author minuzzi
 */
public class Automecanica {

    public static Connection conexao = null;

    public static void main(String[] args) {
        if (openConnection()) {
            new MainFrm().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer a conexão com o banco. Aguarde e tente novamente mais tarde");            
        }  
    }
    
    private static boolean openConnection () {
        try {
            String dbdriver = "com.mysql.jdbc.Driver";
            String dburl = "jdbc:mysql://localhost/mecanica_db";
            String dbuser = "root";
            String dbsenha = "password";

            // Load Driver of the Database
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // Connection with user and password
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // Connection without user and password
            {
                conexao = DriverManager.getConnection(dburl);
            }

            return true;

        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar: " + e);
            return false;
        }
    }
    
}
