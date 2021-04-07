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
public class Item {
    private int id;
    private String name,
                   description;
    private double value;
    private char situation;

    public Item(String name, String description, double value, char situation) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.situation = situation;
    }

    public Item(int id, String name, String description, double value, char situation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.situation = situation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public char getSituation() {
        return situation;
    }

    public void setSituation(char situation) {
        this.situation = situation;
    }
    
    
}
