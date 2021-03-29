/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.sql.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author minuzzi
 */
public class ConexaoDB {
    
    private static ConexaoDB instancia = null;
    private Connection conexao = null;
    
    public ConexaoDB() {
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
//            prop.load(new FileInputStream("db.properties"));
//            String dbdriver = prop.getProperty("db.driver");
//            String dburl = prop.getProperty("db.url");
//            String dbuser = prop.getProperty("db.user");
//            String dbsenha = "password";

            final String dbuser = "root";
            final String dbsenha = "password";
            final String dburl = "jdbc:mysql://localhost/mecanica_db";
            final String dbdriver = "com.mysql.jdbc.Driver";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
                System.out.println(dbdriver);
                System.out.println(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    // Retorna instância
    public static ConexaoDB getInstance() {
        if (instancia == null) {
            instancia = new ConexaoDB();
        }
        return instancia;
    }
    
    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }
    
    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
