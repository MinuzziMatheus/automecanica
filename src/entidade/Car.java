/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author minuzzi
 */
public class Car {
    private int id;
    private String name,
                   model;
    private int year;
    private String carPlate;
    private int client_id;
    private String description_problem;

    public Car(String name, String model, int year, String carPlate, int client_id, String description_problem) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.carPlate = carPlate;
        this.client_id = client_id;
        this.description_problem = description_problem;
    }

    public Car(int id, String name, String model, int year, String carPlate, int client_id, String description_problem) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.carPlate = carPlate;
        this.client_id = client_id;
        this.description_problem = description_problem;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getDescription_problem() {
        return description_problem;
    }

    public void setDescription_problem(String description_problem) {
        this.description_problem = description_problem;
    }
    
    
   
}
