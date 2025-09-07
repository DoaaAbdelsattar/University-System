/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */

public class AdminStaff extends User{
    
 private String staffid;
 private String department;
 private String Rolee;
 
 AdminStaff() {}
 
  AdminStaff(String userId,String username,String password,String name,String email, String contactInfo ){
     super(userId,username,password,name,email,contactInfo , "AdminStaff" );
       this.setStaffid(userId);
     this.setDepartment("Administration");
     this.setRolee("Staff");
    }
 
 AdminStaff(String userId,String username,String password,String name,String email, String contactInfo,String staffid ,String department){
     super(userId,username,password,name,email,contactInfo,"AdminStaff");
     this.setStaffid(staffid);
     this.setDepartment(department);
    this.setRolee(Rolee);
 }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRolee() {
        return Rolee;
    }

    public void setRolee(String Rolee) {
        this.Rolee = Rolee;
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
        System.out.println("AdminStaff: "+this.getUsername()+" logged out successfully.");
    }
    
 @Override
    public void updateProfile(String name, String email, String contactInfo) {
        super.updateProfile(name, email, contactInfo);      
    }

  public void registerStudent(University university, Student student) {
    if (student.getPassword().length() < 6) {
        System.out.println("Registration failed: Password must be at least 6 characters.");
        return; 
    }
    
    university.registerStudent(student);
    System.out.println("Student " + student.getName() + " registered successfully.");
}

     public void createCourse(University university, Course course) {
        university.offerCourse(course);
        System.out.println("Course " + course.getTitle() + " created successfully.");
    }

   
    public void assignFaculty(University university, Course course, Faculty faculty) {
        university.assignFacultyToCourse(course, faculty);
        System.out.println("Faculty " + faculty.getName() + " assigned to " + course.getTitle());
    }
    
     public String generateReport() {
        return "AdminStaff Report for " + getName() + "\n" +
               "Staff ID: " + this.getStaffid() + "\n" +
               "Department: " + this.getDepartment() + "\n" +
               "Role: " + this.getRolee() + "\n";
    }   
     
     
   @Override
    public void showDashboard() {
        System.out.println("Admin Staff Dashboard for " + getName());
        System.out.println("1. Register student");
        System.out.println("2. Create course");
        System.out.println("3. Assign faculty");
        System.out.println("4. Generate reports");
        System.out.println("5. Update profile");
        System.out.println("6. Logout");
    }
     
      
}
