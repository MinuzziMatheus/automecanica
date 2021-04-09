/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.City;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class CityDAO {
    public String createCity(City city){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
        
            String sql = "";
            
            sql = "Insert into estado values "
                    + "(default,"
                    + " '" + city.getName() + "', "
                    + " " + city.getState_id() + ";";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar uma cidade: " + e);
            return e.toString();
        }
    }
    
    public City returnCity(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from cidade where id = " + id + ";";
            
            ResultSet result = stm.executeQuery(sql);
            
            System.out.println("SQL: " + sql);
            result.next();
            City city = new City(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("estado_id")
            );
            return city;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
            return null;
        }
    }
}
