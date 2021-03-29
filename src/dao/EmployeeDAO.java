package dao;


import apoio.ConnectionDB;
import entidade.Employee;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.sql.*;
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
    
//    public String employeeRegister(Employee employee){ 
//        try {
//            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
//            
//            String sql = "";
//            if (employee.getId() == 0) {
//                sql = "Insert into funcionario values "
//                        + "(default,"
//                        + " '" + employee.getName() + "',"
//                        + " '" + employee.getEmail() + "',"
//                        + " '" + employee.getPassword() + "',"
//                        + " '" + employee.getSituation() + "')";
//            } else {
//                sql = "update funcionario "
//                        + "set descricao = '" + employee.getName() + "', "
//                        + "situacao = '" + employee.getSituation() + "' "
//                        + "where id = " + employee.getId();
//            }
//            System.out.println("SQL: " + sql);
//            return null;
//        } catch (Exception e) {
//            System.out.println("Erro ao salvar categoria: " + e);
//            return e.toString();
//        }
//    }
//    
//    public String employeeInactivation(int id){
//        try {
//            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
//            
//            String sql = "update funcionario "
//                    + "set situacao = 'i' "
//                    + "where id = " + id;
//
//            System.out.println("SQL: " + sql);
//
//            int result = stm.executeUpdate(sql);
//
//            return null;
//        } catch (Exception e) {
//            System.out.println("Erro ao excluir/inativar: " + e);
//            return e.toString();
//        }
//    }
}
