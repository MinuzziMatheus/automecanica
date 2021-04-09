/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.Item;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minuzzi
 */
public class ItemDAO {
    public String itemRegister(Item item){ 
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            
            sql = "Insert into item values "
                    + "(default,"
                    + " '" + item.getName() + "',"
                    + " '" + item.getDescription() + "',"
                    + " '" + item.getValue() + "',"
                    + " 'a' ,"
                    + " '" + item.getAmount() + "');"; 
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar item: " + e);
            return e.toString();
        }
    }
//    
    public String itemInactivation(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update item "
                    + "set situacao = 'i' "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao excluir/inativar: " + e);
            return e.toString();
        }
    }
    
    public String itemEdit(Item item){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update item "
                        + "set nome = '" + item.getName() + "', "
                        + "descricao = '" + item.getDescription() + "', "
                        + "valor = '" + item.getValue() + "', "
                        + "quantidade = '" + item.getAmount() + "', "
                        + "situacao = '" + item.getSituation() + "'"
                        + "where id = " + item.getId() + ";";
            
            int result = stm.executeUpdate(sql);
            
            System.out.println("SQL: " + sql);

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar item: " + e);
            return e.toString();
        }
    }
    
    public List<Item> getAll(){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from item";
            
            ResultSet result = null;
            
            result = stm.executeQuery(sql);
            List<Item> listE = new ArrayList<>();
            while (result.next()){
                Item item = new Item(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("descricao"),
                        result.getDouble("valor"),
                        result.getString("situacao").charAt(0),
                        result.getInt("quantidade")
                        
                );
                listE.add(item);
            }
            
            return listE;
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e);
        }
        
        return null;
    }
}
