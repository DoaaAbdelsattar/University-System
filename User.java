/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;
/**
 *
 * @author pc
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.UUID;

abstract class User {
    private String userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String contactInfo;
     private String role;

    User(){}
    User(String userId,String username,String password,String name,String email, String contactInfo , String role){     
        this.setUserId(userId);
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setContactInfo(contactInfo);
        this.setRole(role);
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
      if (password.length()>= 6){
        this.password = password;
       System.out.println("Password updated successfully.");
      }
      else
         System.out.println("Your password  must contain at least 6 characters. ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
   
public boolean login(String username, String password) {
    if (this.username.equals(username.trim()) && this.password.equals(password.trim())) {
        return true;
    }
    return false;
}


  public abstract void logout();

    
    public void updateProfile(String name, String email, String contactInfo) {
        this.setName(name);
        this.setEmail(email);
        this.setContactInfo(contactInfo);
        System.out.println("Profile updated successfully.");
      
    }
    
     public abstract void showDashboard();
}
