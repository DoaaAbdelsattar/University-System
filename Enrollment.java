/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */
public class Enrollment {
 
     private Student student;
    private Course course;
    private String enrollmentDate;
    private String grade;
    private String status;

     public Enrollment(Student student, Course course , String enrollmentDate) {
     this.setStudent(student);
     this.setCourse(course);
     this.setEnrollmentDate(enrollmentDate);
     this.setGrade("null");
     this.setStatus("Active");
     }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
     
    public void assignGrade(){
        this.setGrade(grade);
        System.out.println("Grade " + grade + "assigned for " + student.getName() + "in "  + course.getTitle());
        if (!grade.equals("F")) {
          this.status = "Completed";
    }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void withdraw(){
    this.status = "Withdrawn";
    course.removeStudent(student);
    System.out.println(student.getName() +" withdrew from " + course.getTitle());
    }
}
