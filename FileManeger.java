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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManeger {
    private static final String USER_FILE = "Users.txt";
    private static final String STUDENT_FILE = "Students.txt";
    private static final String COURSE_FILE = "Courses.txt";
    private static final String ENROLLMENT_FILE = "Enrollments.txt";
    private static final String DEPARTMENT_FILE = "Departments.txt";
    
    public void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            String role = user instanceof Student ? "Student" :
                         user instanceof Faculty ? "Faculty" :
                         user instanceof AdminStaff ? "AdminStaff" : "SystemAdmin";
            writer.write(user.getUserId() + "," + user.getUsername() + "," + user.getPassword() + "," +
                       user.getName() + "," + user.getEmail() + "," + user.getContactInfo() + "," + role);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

 public void saveStudent(Student student) {
    try {
        List<String> lines = new ArrayList<>();
        if (Files.exists(Paths.get(STUDENT_FILE))) {
            lines = Files.readAllLines(Paths.get(STUDENT_FILE));
        }

        boolean studentExists = false;
        List<String> updatedLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[0].equals(student.getStudentid())) {

                String updatedLine = student.getStudentid() + "," + student.getUsername() + "," +
                                   student.getName() + "," + student.getAdmissionDate() + "," +
                                   student.getAcademicsStatus() + "," + 
                                   student.getEnrolledCourses().size();
                updatedLines.add(updatedLine);
                studentExists = true;
            } else {
                updatedLines.add(line);
            }
        }

        if (!studentExists) {
            String newLine = student.getStudentid() + "," + student.getUsername() + "," +
                            student.getName() + "," + student.getAdmissionDate() + "," +
                            student.getAcademicsStatus() + "," + 
                            student.getEnrolledCourses().size();
            updatedLines.add(newLine);
        }

        Files.write(Paths.get(STUDENT_FILE), updatedLines);
    } catch (IOException e) {
        System.out.println("Error saving student: " + e.getMessage());
    }
}
       
    public void saveCourse(Course course) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COURSE_FILE, true))) {
            writer.write(course.getCourseId() + "," + course.getTitle() + "," +
                       course.getDescription() + "," + course.getCreditHours() + "," +
                       course.getAvailableSeats() + "," + course.getSchedule());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving course: " + e.getMessage());
        }
    }
       
    public void saveEnrollment(Enrollment enrollment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ENROLLMENT_FILE, true))) {
            writer.write(enrollment.getStudent().getStudentid() + "," +
                       enrollment.getCourse().getCourseId() + "," +
                       enrollment.getEnrollmentDate() + "," +
                       (enrollment.getGrade() != null ? enrollment.getGrade() : "N/A") + "," + enrollment.getStatus());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving enrollment: " + e.getMessage());
        }
    }
       
    public void saveDepartment(Department department) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEPARTMENT_FILE, true))) {
            writer.write(department.getDepartmentId() + "," + department.getName());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving department: " + e.getMessage());
        }
    }
       
    
  public List<User> loadUsers() {
    List<User> users = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 7) {
                User user;
                switch (parts[6]) {
                    case "Student":
                        user = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                        break;
                    case "Faculty":
                        user = new Faculty(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                        break;
                    case "AdminStaff":
                        user = new AdminStaff(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                        break;
                    default:
                        user = new SystemAdmin(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                        break;
                }
                users.add(user);
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading users: " + e.getMessage());
    }
    return users;
}
  
       
    public List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COURSE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Course course = new Course(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), 
                                              Integer.parseInt(parts[4]), parts[5]);        
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
        return courses;
    }   
    
    public void backupAllData() {
    try {
        // First save any unsaved data
        List<User> users = loadUsers();
        // (Similar loads for other data types would go here)
        
        // Create timestamp for backup filenames
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        
        // Define files to backup
        String[] sourceFiles = {USER_FILE, STUDENT_FILE, COURSE_FILE, ENROLLMENT_FILE, DEPARTMENT_FILE};
        
        // Create backups with timestamp
        for (String file : sourceFiles) {
            copyFile(file, "backup_" + timestamp + "_" + file);
        }
        
        System.out.println("Backup created with timestamp: " + timestamp);
    } catch (IOException e) {
        System.out.println("Error creating backup: " + e.getMessage());
    }
}

// Helper method to copy files
private void copyFile(String source, String destination) throws IOException {
    Path sourcePath = Paths.get(source);
    Path destPath = Paths.get(destination);
    
    // Only copy if source exists
    if (Files.exists(sourcePath)) {
        Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
    } else {
        System.out.println("Warning: Source file not found: " + source);
    }
 
}

public void removeEnrollment(Enrollment enrollment) {
    try {
        List<String> lines = Files.readAllLines(Paths.get(ENROLLMENT_FILE));
        
        List<String> updatedLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (!(parts[0].equals(enrollment.getStudent().getStudentid()) && 
                !(parts[1].equals(enrollment.getCourse().getCourseId())))) {
                updatedLines.add(line);
            }
        }
        
        Files.write(Paths.get(ENROLLMENT_FILE), updatedLines);
    } catch (IOException e) {
        System.out.println("Error removing enrollment: " + e.getMessage());
    }
}



}