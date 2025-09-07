/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */
public class StandardGradingSystem implements GradingSystem  {
    
       @Override
    public void assignGrade(Enrollment enrollment, String grade) {
        if (grade.equals("A") || grade.equals("B") || grade.equals("C") ||
            grade.equals("D") || grade.equals("F")) {
            enrollment.setGrade(grade);
            System.out.println("Grade " + grade + " assigned to " + enrollment.getStudent().getName() +
                               " for " + enrollment.getCourse().getTitle());
        } else {
            System.out.println("Invalid grade: " + grade);
        }
    }

    
}
