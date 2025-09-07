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

public class  University{
    
    private List <Department> departments;
    private List <User> users;
    private List <Course> courses;
    private String academicCalendar;

    University() {
        this.departments = new ArrayList<>();
        this.users = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.academicCalendar = "2023-2024";
    }

    // Getters and Setters
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getAcademicCalendar() {
        return academicCalendar;
    }

    public void setAcademicCalendar(String academicCalendar) {
        this.academicCalendar = academicCalendar;
    }
    
    public void registerStudent(Student student) {
        if (!users.contains(student)) {
            users.add(student);
        }
    }

    public void hireFaculty(Faculty faculty) {
        if (!users.contains(faculty)) {
            users.add(faculty);
        }
    }

    public void createDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void offerCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void assignFacultyToCourse(Course course, Faculty faculty) {
        course.setInstructor(faculty);
        faculty.getCoursesTeaching().add(course);
        
        FileManeger fileManager = new FileManeger ();
        fileManager.saveCourse(course); 
    }
    
}
    
    
