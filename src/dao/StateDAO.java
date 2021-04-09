/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.State;
import entidade.State;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class StateDAO {
    public String createState(State state){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
        
            String sql = "";
            
            sql = "Insert into estado values "
                    + "(default,"
                    + " '" + state.getUf() + "';";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar um estado: " + e);
            return e.toString();
        }
    }
    
    public State returnState(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from estado where id = " + id + ";";
            
            ResultSet result = stm.executeQuery(sql);
            
            System.out.println("SQL: " + sql);
            result.next();
            State state = new State(
                        result.getInt("id"),
                        result.getString("uf"),
                        result.getString("nome")                        
            );
            return state;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
            return null;
        }
    }
}
