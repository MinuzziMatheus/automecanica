/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConnectionDB;
import entidade.Car;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minuzzi
 */
public class CarDAO {
    public String createCar(Car car){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
        
            String sql = "";
            
            sql = "Insert into carro values "
                    + "(default,"
                    + " '" + car.getName() + "', "
                    + " '" + car.getModel() + "', "
                    + " '" + car.getYear() + "', "
                    + " '" + car.getCarPlate() + "', "
                    + " " + car.getClient_id() + ", "
                    + " '" + car.getDescription_problem() + "');";
            
            int result = stm.executeUpdate(sql);
            
            String feedBackMessage = ""+result+"";
            
            System.out.println("SQL: " + sql);
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar uma carro: " + e);
            return e.toString();
        }
    }
    
    public String carEdit(Car car){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "update carro "
                        + "set nome = '" + car.getName() + "', "
                        + "modelo = '" + car.getModel() + "', "
                        + "ano = '" + car.getYear() + "', "
                        + "placa = '" + car.getCarPlate() + "',"
                        + "descricao_problema = '" + car.getDescription_problem() + "',"
                        + "where id = " + car.getId() + ";";
            
            int result = stm.executeUpdate(sql);
            
            System.out.println("SQL: " + sql);

            String feedBackMessage = ""+result+"";
            
            return feedBackMessage;
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
    }
    
    public Car returnCar(int id){
        try {
            Statement stm = ConnectionDB.getInstance().getConnection().createStatement();
            
            String sql = "select * from carro where cliente_id = " + id + ";";
            
            ResultSet result = stm.executeQuery(sql);
            
            System.out.println("SQL: " + sql);
            result.next();
            Car car = new Car(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("modelo"),
                        result.getInt("ano"),
                        result.getString("placa"),
                        result.getInt("cliente_id"),
                        result.getString("descricao_problema")
            );
            return car;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
            return null;
        }
    }
}
