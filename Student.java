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


public class Student  extends User {
    
        private static FileManeger fileManager = new FileManeger();
    
     private String studentid ;
     private String admissionDate;
     private String academicsStatus;
     private List <Enrollment> enrolledCourses;
     
     
    Student() { 
    this.enrolledCourses = new ArrayList<>();
    }
        
    Student(String userId,String username,String password,String name,String email, String contactInfo ){
     super(userId,username,password,name,email,contactInfo , "Student");
     this.enrolledCourses = new ArrayList<>();
     this.setStudentid(userId);
     this.setAdmissionDate("2023-09-01");
     this.setAcademicsStatus("Active"); 
    }
    
    Student(String userId,String username,String password,String name,String email, String contactInfo,String studentid ,String admissionDate , String academicsStatus ,String enrolledCourses ){
    super(userId,username,password,name,email,contactInfo,"Student");
    this.setStudentid(studentid);
    this.setAdmissionDate(admissionDate);
    this.setAcademicsStatus(academicsStatus);
    this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentid() {
        return studentid;
    }
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAcademicsStatus() {
        return academicsStatus;
    }

    public void setAcademicsStatus(String academicsStatus) {
        this.academicsStatus = academicsStatus;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    
     @Override
    public String getRole (){
    return "Student";
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
        System.out.println("Student: "+this.getUsername()+" logged out successfully.");
    }
    
     @Override
    public void updateProfile(String name, String email, String contactInfo) {
              super.updateProfile(name, email, contactInfo);      
    }
    
    
    
  public void registerForCourse(Course course, String enrollmentDate) {
    for (Enrollment enrollment : enrolledCourses) {
        if (enrollment.getCourse().equals(course)) {
            System.out.println("Student " + getName() + " is already registered in course " + course.getTitle());
            return;
        }
    }
    if (course.getAvailableSeats() > 0) {
        Enrollment enrollment = new Enrollment(this, course, enrollmentDate);
        this.enrolledCourses.add(enrollment);
        course.addStudent(this);
        
        fileManager.saveStudent(this);
        fileManager.saveEnrollment(enrollment);
        
        System.out.println("Student " + getName() + " registered for course " + course.getTitle());
    } else {
        System.out.println("Cannot register! No available seats in " + course.getTitle());
    }
}
  
  
  public void dropCourse(Course course) {
    for (Enrollment enrollment : enrolledCourses) {
        if (enrollment.getCourse().equals(course)) {
            enrolledCourses.remove(enrollment);
            course.removeStudent(this);
            
            fileManager.saveStudent(this);
            fileManager.removeEnrollment(enrollment);
            
            System.out.println("Student " + getName() + " dropped course " + course.getTitle());
            return;
        }
    }
    System.out.println("Student " + getName() + " is not enrolled in course " + course.getTitle());
}
              
        
public void viewGrades() {
    if (enrolledCourses.isEmpty()) {
        System.out.println("You are not enrolled in any courses.");
        return;
    }

    System.out.println("\nGrades for " + getName() + ":");
    boolean hasGrades = false;
    
    for (Enrollment enrollment : enrolledCourses) {
        if (enrollment.getGrade() != null && !enrollment.getGrade().equals("null")) {
            System.out.println("- " + enrollment.getCourse().getTitle() + 
                             ": " + enrollment.getGrade() + 
                             " (Status: " + enrollment.getStatus() + ")");
            hasGrades = true;
        }
    }
    
    if (!hasGrades) {
        System.out.println("No grades available yet.");
    }
}


     public double calculateGPA() {
    double totalGradePoints = 0.0;
    int totalCreditHours = 0;

    for (Enrollment enrollment : enrolledCourses) {
        String grade = enrollment.getGrade();
        Course course = enrollment.getCourse();
        
        if (grade != null) {
            double gradePoint;
            switch (grade) {
                case "A": gradePoint = 4.0; break;
                case "B": gradePoint = 3.0; break;
                case "C": gradePoint = 2.0; break;
                case "D": gradePoint = 1.0; break;
                default: gradePoint = 0.0; break;
            }
            
            totalGradePoints += gradePoint * course.getCreditHours();
            totalCreditHours += course.getCreditHours();
        }
    }

    if (totalCreditHours == 0) {
        return 0.0;
    }

    return totalGradePoints / totalCreditHours;
}
        
        
        @Override
    public void showDashboard() {
        System.out.println("Student Dashboard for " + getName());
        System.out.println("1. Register for a course");
        System.out.println("2. Drop a course");
        System.out.println("3. View grades");
        System.out.println("4. Calculate GPA");
        System.out.println("5. Update profile");
        System.out.println("6. Logout");
    }  
        
        
        
        
        
        
  
        
  }
  
    
    
    
    
    
    
    
    
    

