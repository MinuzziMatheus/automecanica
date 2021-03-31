/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.EmployeeFunction;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class EmployeeFunctionDAO {
    public String save(EmployeeFunction f) {
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            sql = "Insert into cargo values"
                        + " (default,'" + f.getName() + "',"
                        + " '" + f.getSalary() + "');";

            System.out.println("SQL: " + sql);

            int result = stm.executeUpdate(sql);

            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
    }
}
