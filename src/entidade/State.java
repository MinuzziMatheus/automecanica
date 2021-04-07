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
public class State {
    private int id;
    private String nome;
    private String uf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public int getUf(String uf){
        try{
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            sql = "select max(id) from estado";
//            sql = "SELECT DISTINCT uf FROM estado WHERE estado = " + uf + ";";
            
            ResultSet result = stm.executeQuery(sql);
            System.out.println(sql);
            System.out.println("SQL: " + sql);

            return result.getInt(1);
        } catch (Exception e){
            return 0;
        }
    }
    
}
