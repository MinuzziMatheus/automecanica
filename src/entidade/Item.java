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
    private int id,
            amount;
    private String name,
                   description;
    private double value;
    private char situation;

    public Item(String name, String description, double value, char situation, int amount) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.situation = situation;
        this.amount = amount;
    }

    public Item(int id, String name, String description, double value, char situation, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.situation = situation;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
    
}
