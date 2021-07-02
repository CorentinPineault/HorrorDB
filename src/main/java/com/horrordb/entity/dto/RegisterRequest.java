package com.horrordb.entity.dto;

public class RegisterRequest {
    private String email;
    private String username;
    private String password;

    public RegisterRequest(){

    }

    public RegisterRequest(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    void setEmail(String email){
        this.email = email;
    }

    String getEmail(){
        return this.email;
    }

    void setUsername(String username){
        this.username = username;
    }

    String getUsername(){
        return this.username;
    }

    void setPassword(String password){
        this.password = password;
    }

    String getPassword(){
        return this.password;
    }
}
