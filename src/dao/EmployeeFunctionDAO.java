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
    public String salvar(EmployeeFunction f) {
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            sql = "Insert into cargo values"
                        + " (default,'" + f.getName() + "',"
                        + " '" + f.getSalary() + "');";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            
            
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
    }
}
