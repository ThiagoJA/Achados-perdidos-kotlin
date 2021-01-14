package com.example.achadosperdidos.dto;


public class DtoUser {

    private String cpf;
    private String email;
    private int id;
    private String name;
    private String password;
    private String phone;

    public DtoUser(String cpf, String email, String name, String password, String phone) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}