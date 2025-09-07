/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */
import java.util.ArrayList;
import java.util.List;

public class SystemAdmin extends User {
    
    private String adminId;
    private String securityLevel;
       private List<User> users; 
    
    SystemAdmin(){}
    
    SystemAdmin(String userId,String username,String password,String name,String email, String contactInfo){
     super(userId,username,password,name,email,contactInfo , "SystemAdmin");
             this.users = new ArrayList<>();

    }
    
    
    SystemAdmin(String userId,String username,String password,String name,String email, String contactInfo,String adminId,String securityLevel ){
        super(userId,username,password,name,email,contactInfo , "SystemAdmin");
        this.setAdminId(adminId);
        this.setSecurityLevel(securityLevel);
                this.users = new ArrayList<>();

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }
    
      @Override
    public String getRole(){
      return "Faculty";
    }
    
      @Override
 public boolean login(String username, String password) {
    if (this.getUsername().equals(username.trim()) && this.getPassword().equals(password.trim())) {
        return true;
    }
    return false;
}

     @Override
    public void logout(){
        System.out.println("SystemAdmin: "+this.getUsername()+" logged out successfully.");
    }
    
    @Override
    public void updateProfile(String name, String email, String contactInfo) {
       super.updateProfile(name, email, contactInfo);      
    }
    
    public void createUser(String userId, String username, String password, String name, String email, 
                          String contactInfo, String role) {
        if (password.length() < 6) {
            System.out.println("Cannot create user: Password must be at least 6 characters.");
            return;
        }
        User newUser;
        switch (role.toLowerCase()) {
            case "systemadmin":
                newUser = new SystemAdmin(userId, username, password, name, email, contactInfo);
                break;
            case "student":
                newUser = new Student(userId, username, password, name, email, contactInfo);

                break;
            case "faculty":
                newUser = new Faculty(userId, username, password, name, email, contactInfo); 
                                   
                break;
            case "adminstaff":
                newUser = new AdminStaff(userId, username, password, name, email, contactInfo, 
                                       "Administration", "Registrar");
                break;
            default:
                System.out.println("Invalid role: " + role);
                return;
        }
        users.add(newUser);
        System.out.println("User created with role " + role + ": " + username);
    }
    
    
       public void modifySystemSettings(String setting, String value) {
        if (setting == null || value == null || setting.isEmpty() || value.isEmpty()) {
            System.out.println("Error: Setting and value cannot be null or empty.");
            return;
        }
            System.out.println("System setting '" + setting + "' modified to '" + value + "' by admin " + this.getUsername() + ".");
       }

       
    public void backupData(FileManeger fileManager) {
        fileManager.backupAllData();
        System.out.println("System data backup completed successfully.");
    }
    
    
   public void managePermissions(String username, String permissionLevel) {
        if (username == null || permissionLevel == null || username.isBlank() || permissionLevel.isBlank()) {
            System.out.println("Error: Username and permission level cannot be null or empty.");
            return;
        }
        System.out.println("Permission level '" + permissionLevel + "' assigned to user '" + username + "' by admin " + getUsername() + " successfully.");

    }
    
    
       @Override
    public void showDashboard() {
        System.out.println("System Admin Dashboard for " + getName());
        System.out.println("1. Create user");
        System.out.println("2. Modify system settings");
        System.out.println("3. Backup data");
        System.out.println("4. Manage permissions");
        System.out.println("5. Update profile");
        System.out.println("6. Logout");
    }
        
          
}
