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
public class Employee {
    private int id;
    private String email,
                   name,
                   password;
    private char situation;
    private int function_id;

    public Employee(String email, String name, String password, char situation, int function_id) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.situation = situation;
        this.function_id = function_id;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSituation() {
        return situation;
    }

    public void setSituation(char situation) {
        this.situation = situation;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }
    
    
}
