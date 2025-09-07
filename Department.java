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

public class Department {
    
    private String departmentId;
    private String name;
    private List<Faculty> faculty;
    private List<Course> offeredCourses;
    
    Department(){}
    
    Department(String departmentId ,String name , String faculty , String offeredCourses){
     this.setDepartmentId(departmentId);
     this.setName(name);
     this.faculty = new ArrayList<>();
     this.offeredCourses = new ArrayList<>();
    }
    
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFaculty(List<Faculty> faculty) {
        this.faculty = faculty;
    }

    public List<Course> getOfferedCourses() {
        return offeredCourses;
    }

    public void setOfferedCourses(List<Course> offeredCourses) {
        this.offeredCourses = offeredCourses;
    }

    public void addFaculty(Faculty faculty) {
        if (!this.faculty.contains(faculty)) {
            this.faculty.add(faculty);
            faculty.setDepartment(this.name);
        }
    }

    public void removeFaculty(Faculty faculty) {
        this.faculty.remove(faculty);
    }

    public void addCourse(Course course) {
        if (!offeredCourses.contains(course)) {
            offeredCourses.add(course);
        }
    }

      public List<Faculty> getFacultyList() {
            return new ArrayList<>(faculty);
    }
            
}
