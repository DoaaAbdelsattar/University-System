/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */

import java.io.*;
import java.util.*;
import java.util.UUID;

    public class Course {
    private String courseId;
    private String title;
    private String description;
    private int creditHours;
    private List <String> prerequisites;
    private String schedule;
    private Faculty instructor;
    private List <Student> enrolledStudents;
    private int maxCapacity;
    
    Course(){
     this.prerequisites= new ArrayList<>();
     this.enrolledStudents= new ArrayList<>();
    }
    
    Course(String courseId,String title,String description,int creditHours,int maxCapacity, String schedule ){
        this.setCourseId(courseId);
        this.setTitle(title);
        this.setDescription(description);
        this.setCreditHours(creditHours);
        this.setSchedule(schedule);
        this.setMaxCapacity(maxCapacity);
        this.instructor = null;
        this.prerequisites= new ArrayList<>();
        this.enrolledStudents= new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }


    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }


    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
     public void addStudent(Student student){
         if(this.enrolledStudents.size()<this.maxCapacity)
            enrolledStudents.add(student);
    }
     
      public void  removeStudent(Student student){
          this.enrolledStudents.remove(student);
    }
      
      
      public int getAvailableSeats() {
          return maxCapacity - this.enrolledStudents.size();
    }
      
       
      public boolean isPrerequisiteSatisfied(Student student){
          
         if (prerequisites.isEmpty()) {
            return true;
        }

        List <Enrollment> studentEnrollments = student.getEnrolledCourses();

        for (String prereqId : prerequisites) {
            
            boolean prereqSatisfied = false;
            
            for (Enrollment enrollment : studentEnrollments) {
                if (enrollment.getCourse().getCourseId().equals(prereqId) && 
                    enrollment.getStatus().equals("Completed")) {
                    prereqSatisfied = true;
                    break;
                }
            }

            if (!prereqSatisfied) {
                System.out.println("Prerequisite " + prereqId + " not satisfied for " + student.getName() + " in " + title);
                return false;
            }
        }

        System.out.println("All prerequisites satisfied for " + student.getName() + " in " + title);
        return true;
    } 
      
    }   
        
        
        
        
