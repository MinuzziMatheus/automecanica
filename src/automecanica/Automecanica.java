/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automecanica;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author minuzzi
 */
public class Automecanica {

    public static Connection conexao = null;

    public static void main(String[] args) {
        if (abrirConexao()) {
//            new FrmPrincipal().setVisible(true);
        } else {
//            JOptionPane.showMessageDialog(null, "Errrroouuuu");            
        }  
    }
    
    private static boolean abrirConexao () {
        try {
            String dbdriver = "com.mysql.jdbc.Driver";
            String dburl = "jdbc:mysql://localhost/mecanica_db";
            String dbuser = "root";
            String dbsenha = "password";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
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
