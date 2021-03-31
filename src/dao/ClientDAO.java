/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.Client;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minuzzi
 */
public class ClientDAO {
    public String clientRegister(Client client){ 
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            
            sql = "Insert into cliente values "
                    + "(default,"
                    + " '" + client.getName() + "',"
                    + " '" + client.getPassword() + "',"
                    + " '" + client.getCpf() + "',"
                    + " '" + client.getEmail() + "',"
                    + " 'a'";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar cliente: " + e);
            return e.toString();
        }
    }
//    
    public String clientInactivation(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update cliente "
                    + "set situacao = 'i' "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao excluir/inativar cliente: " + e);
            return e.toString();
        }
    }
    
    public String clientEdit(Client client){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update cliente "
                        + "set nome = '" + client.getName() + "', "
                        + "senha = '" + client.getPassword() + "', "
                        + "cpf = '" + client.getCpf()+ "', "
                        + "email = '" + client.getEmail() + "', "
                        + "situacao = '" + client.getSituation() + "', "
                        + "where id = " + client.getId() + ";";
            
            int result = stm.executeUpdate(sql);
            
            System.out.println("SQL: " + sql);

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
    }
    
    public List<Client> getAll(){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from cliente";
            
            ResultSet result = null;
            
            result = stm.executeQuery(sql);
            List<Client> listE = new ArrayList<>();
            while (result.next()){
                Client client = new Client(
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6).charAt(0)
                );
                listE.add(client);
            }
            
            return listE;
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e);
        }
        
        return null;
    }
}
