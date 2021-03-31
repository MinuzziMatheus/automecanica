package dao;


import apoio.ConnectionDB;
import entidade.Employee;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minuzzi
 */
public class EmployeeDAO {
    
    public String employeeRegister(Employee employee){ 
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "";
            
            sql = "Insert into funcionario values "
                    + "(default,"
                    + " '" + employee.getName() + "',"
                    + " '" + employee.getEmail() + "',"
                    + " '" + employee.getPassword() + "',"
                    + " 'a'," 
                    + " " + employee.getFunction_id() + ");";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
    }
//    
    public String employeeInactivation(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update funcionario "
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
    
    public String employeeEdit(Employee employee){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update funcionario "
                        + "set descricao = '" + employee.getName() + "', "
                        + "senha = '" + employee.getPassword() + "', "
                        + "cargo_id = '" + employee.getFunction_id() + "', "
                        + "email = '" + employee.getEmail() + "', "
                        + "situacao = '" + employee.getSituation() + "'"
                        + "where id = " + employee.getId() + ";";
            
            int result = stm.executeUpdate(sql);
            
            System.out.println("SQL: " + sql);

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
    }
    
    public List<Employee> getAll(){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from funcionario";
            
            ResultSet result = null;
            
            result = stm.executeQuery(sql);
            List<Employee> listE = new ArrayList<>();
            while (result.next()){
                Employee employee = new Employee(
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(6).charAt(0),
                        result.getInt(5)
                        
                );
                listE.add(employee);
            }
            
            return listE;
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e);
        }
        
        return null;
    }
}
