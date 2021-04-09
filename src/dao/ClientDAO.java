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
                    + " '" + client.getCpf() + "',"
                    + " '" + client.getEmail() + "')";
            
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
//    public String clientInactivation(int id){
//        try {
//            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
//            
//            String sql = "update cliente "
//                    + "set situacao = 'i' "
//                    + "where id = " + id;
//
//            System.out.println("SQL: " + sql);
//            
//            int result = stm.executeUpdate(sql);
//            
//            String feedBackMessage = ""+result+"";
//            
//            return feedBackMessage;
//        } catch (Exception e) {
//            System.out.println("Erro ao excluir/inativar cliente: " + e);
//            return e.toString();
//        }
//    }
    
    public String clientEdit(Client client){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update cliente "
                        + "set nome = '" + client.getName() + "', "
                        + "cpf = '" + client.getCpf()+ "', "
                        + "email = '" + client.getEmail() + "' "
                        + "where id = " + client.getId() + ";";
            
            int result = stm.executeUpdate(sql);

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e);
            return e.toString();
        }
    }
    
    public Client returnClient(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from cliente where id = " + id + ";";
            
            ResultSet result = stm.executeQuery(sql);
            
            System.out.println("SQL: " + sql);
            result.next();
            Client client = new Client(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("cpf"),
                        result.getString("email")
            );
            return client;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
            return null;
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
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("cpf"),
                        result.getString("email"));
                listE.add(client);
            }
            
            return listE;
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e);
        }
        
        return null;
    }
    
    public int getLastId(){
        try{
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            sql = "select MAX(id) from cliente group by id;";
            ResultSet result = stm.executeQuery(sql);
            System.out.println("SQL: " + sql);
            result.next();
            return result.getInt(1);
        } catch (Exception e){
            return 0;
        }
    }
}
