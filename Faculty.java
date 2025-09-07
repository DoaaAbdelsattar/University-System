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

public class Faculty extends User {
    
 private String facultyid;   
 private String department;
 private List<String> expertise; 
 private List<Course> coursesTeaching;

 Faculty() {}
 
 Faculty(String userId,String username,String password,String name,String email, String contactInfo){
     super(userId,username,password,name,email,contactInfo , "Faculty");
     this.setFacultyid(facultyid);
     this.setDepartment("Computer Science");
      this.expertise = new ArrayList <>();
     this.coursesTeaching = new ArrayList <>();
    }
    
 
 Faculty(String userId,String username,String password,String name,String email, String contactInfo,String staffid ,String department , String expertise , String coursesTeaching ){
     super(userId,username,password,name,email,contactInfo,"Faculty");
     this.setStaffid(staffid);
     this.setDepartment(department);
     this.expertise = new ArrayList <>();
     this.coursesTeaching = new ArrayList <>();

 }

    public String getStaffid() {
        return facultyid;
    }

    public void setStaffid(String staffid) {
        this.facultyid = staffid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<String> expertise) {
        this.expertise = expertise;
    }

    public List<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    public void setCoursesTeaching(List<Course> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
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
        System.out.println("Faculty: "+this.getUsername()+" logged out successfully.");
    }
    
  @Override
    public void updateProfile(String name, String email, String contactInfo) {
              super.updateProfile(name, email, contactInfo);
      
    }

 public void assignGrades(Course course, Student student, String grade) {
    if (!coursesTeaching.contains(course)) {
        System.out.println("Error: Not assigned to course: " + course.getTitle());
        return;
    }
    if (!course.getEnrolledStudents().contains(student)) {
        System.out.println("Error: Student not in " + course.getTitle());
        return;
    }
    
    for (Enrollment enrollment : student.getEnrolledCourses()) {
        if (enrollment.getCourse().equals(course)) {
            enrollment.setGrade(grade);
            enrollment.setStatus("Completed");
            
            FileManeger fileManager = new FileManeger ();
            fileManager.saveEnrollment(enrollment);
            
            System.out.println("Assigned grade " + grade + " to " + student.getName());
            return;
        }
    }
    System.out.println("Error: Student not in course: " + course.getTitle());
}
   
    
    public void manageCourse(Course course, String newSchedule, String newDescription) {
         if (!coursesTeaching.contains(course)) {
            System.out.println("Error: Not assigned to course: " + course.getTitle());
            return;
        }
     course.setSchedule(newSchedule);
     course.setDescription(newDescription);
     System.out.println("Course " + course.getTitle() + " updated. New schedule: " + newSchedule +   ", New description: " + newDescription);
    }
    
    
      public void setOfficeHours(String officeHours) {
        System.out.println("Set office hours: " + officeHours);
    }
    
       public void viewStudentRoster(Course course) {
        if (!coursesTeaching.contains(course)) {
            System.out.println("Not teaching " + course.getTitle());
        }
           System.out.println("Students are enrolled in " +course.getTitle() + ":");
        for (Student student : course.getEnrolledStudents()) {
            System.out.println(student.getName());
       }
       }
       
   @Override
    public void showDashboard() {
        System.out.println("Faculty Dashboard for " + getName());
        System.out.println("1. Assign grades");
        System.out.println("2. Manage course");
        System.out.println("3. Set office hours");
        System.out.println("4. View student roster");
        System.out.println("5. Update profile");
        System.out.println("6. Logout");  
    }
    
    
}
