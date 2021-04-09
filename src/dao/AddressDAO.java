/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.Address;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class AddressDAO {
    public String createAddress(Address address){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
        
            String sql = "";
            
            sql = "Insert into endereco values "
                    + "(default,"
                    + " '" + address.getStreet() + "', "
                    + " '" + address.getNumber() + "', "
                    + " '" + address.getNeighborhood() + "', "
                    + " " + address.getClient_id() + ", "
                    + " " + address.getCity_id() + ");";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar um endereço: " + e);
            return e.toString();
        }
    }
    
    public String editAddress(Address address){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update endereco "
                        + "set rua = '" + address.getStreet() + "', "
                        + "numero = '" + address.getNumber()+ "', "
                        + "bairro = '" + address.getNeighborhood()+ "', "
                        + "cidade_id = " + address.getCity_id()
                        + " where id = " + address.getId() + ";";
            
            int result = stm.executeUpdate(sql);
            
            System.out.println("SQL: " + sql + "AAAAAAAa" + address.getId());

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar endereço: " + e);
            return e.toString();
        }
    }
    
//    public Address returnAddressId(int id){
//        try {
//            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
//            
//            String sql = "select * from endereco where id = " + id + ";";
//            
//            ResultSet result = stm.executeQuery(sql);
//            
//            result.next();
//            Address address = new Address(
//                        result.getInt("id"),
//                        result.getString("rua"),
//                        result.getString("numero"),
//                        result.getString("bairro"),
//                        result.getInt("cliente_id"),
//                        result.getInt("cidade_id")
//                        
//            );
//            return address;
//        } catch (Exception e) {
//            System.out.println("Erro ao salvar: " + e);
//            return null;
//        }
//    }
    
    
    public Address returnAddress(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from endereco where cliente_id = " + id + ";";
            
            ResultSet result = stm.executeQuery(sql);
            
            result.next();
            Address address = new Address(
                        result.getInt("id"),
                        result.getString("rua"),
                        result.getString("numero"),
                        result.getString("bairro"),
                        result.getInt("cliente_id"),
                        result.getInt("cidade_id")
            );
            return address;
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return null;
        }
    }
}
