/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import apoio.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class City {
    private int id;
    private String name;
    private int state_id;

    public City(String name, int state_id) {
        this.name = name;
        this.state_id = state_id;
    }

    public City(int id, String name, int state_id) {
        this.id = id;
        this.name = name;
        this.state_id = state_id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }
    
    public int getLastId(){
        try{
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            
            sql = "select max(id) from cidade";
            
            ResultSet result = stm.executeQuery(sql);
            
            System.out.println("SQL: " + sql);

            return result.getInt(1);
        } catch (Exception e){
            return 0;
        }
    }
    
}
