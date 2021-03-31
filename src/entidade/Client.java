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
public class Client {
    private int id;
    private String name,
                   password,
                   cpf,
                   email;
    private char situation;

    public Client(String name, String password, String cpf, String email, char situation) {
        this.name = name;
        this.password = password;
        this.cpf = cpf;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSituation() {
        return situation;
    }

    public void setSituation(char situation) {
        this.situation = situation;
    }    
    
}
