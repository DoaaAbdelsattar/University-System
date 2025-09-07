/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalprojectds;

/**
 *
 * @author pc
 */
import java.util.*;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalProjectDS {
    
private static University university = new University();
    private static FileManeger fileManager = new FileManeger();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;
    
    
    public static void main(String[] args) {
        
        // Load initial data
        loadInitialData();
        
        // Main menu
        while (true) {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
     private static void loadInitialData() {
        // Load users from file
        university.setUsers(fileManager.loadUsers());
        
        // For demo purposes, add some initial data if files are empty
      if (university.getUsers().isEmpty()) {
        System.out.println("Creating initial data...");
        
        // Create sample users
            Student student1 = new Student("S1001", "student1", "password123", "Ali Mohamed", "ali@univ.edu", "01012345678");
            Student student2 = new Student("S1002", "student2", "password123", "Mona Ahmed", "mona@univ.edu", "01011112222");
            Student student3 = new Student("S1003", "student3", "password123", "Omar Khaled", "omar@univ.edu", "01022223333");
            Student student4 = new Student("S1004", "student4", "password123", "Hala Samir", "hala@univ.edu", "01033334444");
            Student student5 = new Student("S1005", "student5", "password123", "Youssef Mahmoud", "youssef@univ.edu", "01044445555");
            
            Faculty faculty1 = new Faculty("F1001", "prof1", "password123", "Dr. Ahmed", "ahmed@univ.edu", "01098765432");
            Faculty faculty2 = new Faculty("F1002", "prof2", "password123", "Dr. Samy", "samy@univ.edu", "01088889999");
            Faculty faculty3 = new Faculty("F1003", "prof3", "password123", "Dr. Hana", "hana@univ.edu", "01077776666");
            Faculty faculty4 = new Faculty("F1004", "prof4", "password123", "Dr. Karim", "karim@univ.edu", "01066665555");
            Faculty faculty5 = new Faculty("F1005", "prof5", "password123", "Dr. Laila", "laila@univ.edu", "01055554444");
            
            AdminStaff admin1 = new AdminStaff("A1001", "admin1", "password123", "Admin User", "admin@univ.edu", "01055555555");
            AdminStaff admin2 = new AdminStaff("A1002", "admin2", "password123", "Admin Assistant", "admin2@univ.edu", "01044443333");
            AdminStaff admin3 = new AdminStaff("A1003", "admin3", "password123", "Registration Staff", "reg@univ.edu", "01033332222");
            
            SystemAdmin sysAdmin1 = new SystemAdmin("SA1001", "sysadmin1", "admin123", "System Admin", "sysadmin@univ.edu", "01022221111");
            SystemAdmin sysAdmin2 = new SystemAdmin("SA1002", "sysadmin2", "admin123", "Tech Support", "tech@univ.edu", "01011110000");
            
        // Add to university
        
            university.registerStudent(student1);
            university.registerStudent(student2);
            university.registerStudent(student3);
            university.registerStudent(student4);
            university.registerStudent(student5);
            
            
            university.hireFaculty(faculty1);
            university.hireFaculty(faculty2);
            university.hireFaculty(faculty3);
            university.hireFaculty(faculty4);
            university.hireFaculty(faculty5);
            
            university.getUsers().add(admin1);
            university.getUsers().add(admin2);
            university.getUsers().add(admin3);
            
            university.getUsers().add(sysAdmin1);
            university.getUsers().add(sysAdmin2);
            
            
        // Create sample department
            Department csDept = new Department("CS101", "Computer Science", "", "");
            Department mathDept = new Department("MATH102", "Mathematics", "", "");
            Department engDept = new Department("ENG103", "Engineering", "", "");
            Department busDept = new Department("BUS104", "Business", "", "");
            Department artDept = new Department("ART105", "Arts", "", "");
            
            university.createDepartment(csDept);
            university.createDepartment(mathDept);
            university.createDepartment(engDept);
            university.createDepartment(busDept);
            university.createDepartment(artDept);
            
            
            
            
        // Create sample course
            Course javaCourse = new Course("CSC101", "Java Programming", "Introduction to Java", 3, 30, "Mon/Wed 10:00-11:30");
            Course dbCourse = new Course("CSC102", "Database Systems", "SQL and DB Design", 4, 25, "Sun/Tue 9:00-10:30");
            Course mathCourse = new Course("MATH201", "Calculus", "Advanced Mathematics", 3, 40, "Mon/Wed 8:00-9:30");
            Course engCourse = new Course("ENG301", "Engineering Basics", "Introduction to Engineering", 2, 35, "Sat/Mon 12:00-1:30");
            Course artCourse = new Course("ART401", "Art History", "History of Modern Art", 2, 20, "Tue/Thu 3:00-4:30");
            
            university.offerCourse(javaCourse);
            university.offerCourse(dbCourse);
            university.offerCourse(mathCourse);
            university.offerCourse(engCourse);
            university.offerCourse(artCourse);
            
            
        // Assign faculty to course
            university.assignFacultyToCourse(javaCourse, faculty1);
            university.assignFacultyToCourse(dbCourse, faculty2);
            university.assignFacultyToCourse(mathCourse, faculty3);
            university.assignFacultyToCourse(engCourse, faculty4);
            university.assignFacultyToCourse(artCourse, faculty5);
            
            
        // Sample enrollment
            student1.registerForCourse(javaCourse, "2023-09-01");
            student2.registerForCourse(dbCourse, "2023-09-01");
            student3.registerForCourse(mathCourse, "2023-09-01");
            student4.registerForCourse(engCourse, "2023-09-01");
            student5.registerForCourse(artCourse, "2023-09-01");
            
            
        // Save all data to files
   fileManager.saveUser(student1);
            fileManager.saveUser(student2);
            fileManager.saveUser(student3);
            fileManager.saveUser(student4);
            fileManager.saveUser(student5);
            
            fileManager.saveUser(faculty1);
            fileManager.saveUser(faculty2);
            fileManager.saveUser(faculty3);
            fileManager.saveUser(faculty4);
            fileManager.saveUser(faculty5);
            
            fileManager.saveUser(admin1);
            fileManager.saveUser(admin2);
            fileManager.saveUser(admin3);
            fileManager.saveUser(sysAdmin1);
            fileManager.saveUser(sysAdmin2);
            
            fileManager.saveDepartment(csDept);
            fileManager.saveDepartment(mathDept);
            fileManager.saveDepartment(engDept);
            fileManager.saveDepartment(busDept);
            fileManager.saveDepartment(artDept);
            
            fileManager.saveCourse(javaCourse);
            fileManager.saveCourse(dbCourse);
            fileManager.saveCourse(mathCourse);
            fileManager.saveCourse(engCourse);
            fileManager.saveCourse(artCourse);
            
            fileManager.saveEnrollment(student1.getEnrolledCourses().get(0));
            fileManager.saveEnrollment(student2.getEnrolledCourses().get(0));
            fileManager.saveEnrollment(student3.getEnrolledCourses().get(0));
            fileManager.saveEnrollment(student4.getEnrolledCourses().get(0));
            fileManager.saveEnrollment(student5.getEnrolledCourses().get(0));
        }
    
    }
    private static void login() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        for (User user : university.getUsers()) {
            if (user.login(username, password)) {
                currentUser = user;
                System.out.println("\nWelcome, " + user.getName() + "!");
                showUserDashboard();
                return;
            }
        }
        
        System.out.println("Invalid username or password.");
    }
    
    private static void showUserDashboard() {
        while (currentUser != null) {
            currentUser.showDashboard();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (currentUser instanceof Student) {
                handleStudentOptions(choice);
            } else if (currentUser instanceof Faculty) {
                handleFacultyOptions(choice);
            } else if (currentUser instanceof AdminStaff) {
                handleAdminStaffOptions(choice);
            } else if (currentUser instanceof SystemAdmin) {
                handleSystemAdminOptions(choice);
            }
        }
    }
    
    private static void handleStudentOptions(int choice) {
        Student student = (Student) currentUser;
        switch (choice) {
            case 1: // Register for course
                System.out.println("\nAvailable Courses:");
                for (Course course : university.getCourses()) {
                    System.out.println(course.getCourseId() + ": " + course.getTitle() + 
                                     " (Seats: " + course.getAvailableSeats() + ")");
                }
                System.out.print("Enter course ID to register: ");
                String courseId = scanner.nextLine();
                
                Course selectedCourse = findCourseById(courseId);
                if (selectedCourse != null) {
                    student.registerForCourse(selectedCourse, "2023-09-01");
                    fileManager.saveEnrollment(student.getEnrolledCourses().get(student.getEnrolledCourses().size() - 1));
                } else {
                    System.out.println("Course not found.");
                }
                break;
            case 2: // Drop course
                System.out.println("\nYour Enrolled Courses:");
                for (Enrollment enrollment : student.getEnrolledCourses()) {
                    System.out.println(enrollment.getCourse().getCourseId() + ": " + 
                                     enrollment.getCourse().getTitle());
                }
                System.out.print("Enter course ID to drop: ");
                courseId = scanner.nextLine();
                
                selectedCourse = findCourseById(courseId);
                if (selectedCourse != null) {
                    student.dropCourse(selectedCourse);
                    // Note: In a real system, we'd need to update the enrollment file
                } else {
                    System.out.println("Course not found.");
                }
                break;
            case 3: // View grades
                student.viewGrades();
                break;
            case 4: // Calculate GPA
                student.calculateGPA();
                break;
            case 5: // Update profile
                updateProfile();
                break;
            case 6: // Logout
                currentUser.logout();
                currentUser = null;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void handleFacultyOptions(int choice) {
        Faculty faculty = (Faculty) currentUser;
        switch (choice) {
            case 1: // Assign grades
                System.out.println("\nCourses you teach:");
                for (Course course : faculty.getCoursesTeaching()) {
                    System.out.println(course.getCourseId() + ": " + course.getTitle());
                }
                System.out.print("Enter course ID: ");
                String courseId = scanner.nextLine();
                
                Course selectedCourse = findCourseById(courseId);
                if (selectedCourse != null) {
                    System.out.println("Students in this course:");
                    for (Student student : selectedCourse.getEnrolledStudents()) {
                        System.out.println(student.getStudentid() + ": " + student.getName());
                    }
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    
                    Student selectedStudent = findStudentById(studentId);
                    if (selectedStudent != null) {
                        System.out.print("Enter grade (A, B, C, D, F): ");
                        String grade = scanner.nextLine();
                        faculty.assignGrades(selectedCourse, selectedStudent, grade);
                        // Note: In a real system, we'd need to update the enrollment file
                    } else {
                        System.out.println("Student not found.");
                    }
                } else {
                    System.out.println("Course not found.");
                }
                break;
            case 2: // Manage course
                System.out.println("\nCourses you teach:");
                for (Course course : faculty.getCoursesTeaching()) {
                    System.out.println(course.getCourseId() + ": " + course.getTitle());
                }
                System.out.print("Enter course ID to manage: ");
                courseId = scanner.nextLine();
                
                selectedCourse = findCourseById(courseId);
                if (selectedCourse != null) {
                    System.out.print("Enter new schedule: ");
                    String schedule = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String description = scanner.nextLine();
                    
                    faculty.manageCourse(selectedCourse, schedule, description);
                    fileManager.saveCourse(selectedCourse);
                } else {
                    System.out.println("Course not found.");
                }
                break;
            case 3: // Set office hours
                System.out.print("Enter your office hours: ");
                String officeHours = scanner.nextLine();
                faculty.setOfficeHours(officeHours);
                break;
            case 4: // View student roster
                System.out.println("\nCourses you teach:");
                for (Course course : faculty.getCoursesTeaching()) {
                    System.out.println(course.getCourseId() + ": " + course.getTitle());
                }
                System.out.print("Enter course ID: ");
                courseId = scanner.nextLine();
                
                selectedCourse = findCourseById(courseId);
                if (selectedCourse != null) {
                    faculty.viewStudentRoster(selectedCourse);
                } else {
                    System.out.println("Course not found.");
                }
                break;
            case 5: // Update profile
                updateProfile();
                break;
            case 6: // Logout
                currentUser.logout();
                currentUser = null;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void handleAdminStaffOptions(int choice) {
        AdminStaff admin = (AdminStaff) currentUser;
        switch (choice) {
            case 1: // Register student
                System.out.print("Enter student ID: ");
                String studentId = scanner.nextLine();
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter contact info: ");
                String contactInfo = scanner.nextLine();
                
                Student newStudent = new Student(studentId, username, password, name, email, contactInfo);
                admin.registerStudent(university, newStudent);
                fileManager.saveUser(newStudent);
                fileManager.saveStudent(newStudent);
                break;
            case 2: // Create course
                System.out.print("Enter course ID: ");
                String courseId = scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter credit hours: ");
                int creditHours = scanner.nextInt();
                System.out.print("Enter max capacity: ");
                int maxCapacity = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter schedule: ");
                String schedule = scanner.nextLine();
                
                Course newCourse = new Course(courseId, title, description, creditHours, maxCapacity, schedule);
                admin.createCourse(university, newCourse);
                fileManager.saveCourse(newCourse);
                break;
            case 3: // Assign faculty
                System.out.println("\nAvailable Faculty:");
                for (User user : university.getUsers()) {
                    if (user instanceof Faculty) {
                        System.out.println(user.getUserId() + ": " + user.getName());
                    }
                }
                System.out.print("Enter faculty ID: ");
                String facultyId = scanner.nextLine();
                
                System.out.println("\nAvailable Courses:");
                for (Course course : university.getCourses()) {
                    System.out.println(course.getCourseId() + ": " + course.getTitle());
                }
                System.out.print("Enter course ID: ");
                courseId = scanner.nextLine();
                
                Faculty faculty = (Faculty) findUserById(facultyId);
                Course course = findCourseById(courseId);
                
                if (faculty != null && course != null) {
                    admin.assignFaculty(university, course, faculty);
                    fileManager.saveCourse(course);
                } else {
                    System.out.println("Faculty or course not found.");
                }
                break;
            case 4: // Generate reports
                System.out.println(admin.generateReport());
                break;
            case 5: // Update profile
                updateProfile();
                break;
            case 6: // Logout
                currentUser.logout();
                currentUser = null;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void handleSystemAdminOptions(int choice) {
        SystemAdmin admin = (SystemAdmin) currentUser;
        switch (choice) {
            case 1: // Create user
                System.out.print("Enter user ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter contact info: ");
                String contactInfo = scanner.nextLine();
                System.out.print("Enter role (Student/Faculty/AdminStaff/SystemAdmin): ");
                String role = scanner.nextLine();
                
                admin.createUser(userId, username, password, name, email, contactInfo, role);
                
                // Save the new user to file
                User newUser = findUserById(userId);
                if (newUser != null) {
                    fileManager.saveUser(newUser);
                    if (newUser instanceof Student) {
                        fileManager.saveStudent((Student) newUser);
                    }
                }
                break;
            case 2: // Modify system settings
                System.out.print("Enter setting name: ");
                String setting = scanner.nextLine();
                System.out.print("Enter new value: ");
                String value = scanner.nextLine();
                admin.modifySystemSettings(setting, value);
                break;
            case 3: // Backup data
                admin.backupData(fileManager);
                break;
            case 4: // Manage permissions
                System.out.print("Enter username to modify permissions: ");
                username = scanner.nextLine();
                System.out.print("Enter new permission level: ");
                String permissionLevel = scanner.nextLine();
                admin.managePermissions(username, permissionLevel);
                break;
            case 5: // Update profile
                updateProfile();
                break;
            case 6: // Logout
                currentUser.logout();
                currentUser = null;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void updateProfile() {
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new contact info: ");
        String contactInfo = scanner.nextLine();
        
        currentUser.updateProfile(name, email, contactInfo);
        fileManager.saveUser(currentUser);
    }
    
    private static Course findCourseById(String courseId) {
        for (Course course : university.getCourses()) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
    
    private static Student findStudentById(String studentId) {
        for (User user : university.getUsers()) {
            if (user instanceof Student && user.getUserId().equals(studentId)) {
                return (Student) user;
            }
        }
        return null;
    }
    
    private static User findUserById(String userId) {
        for (User user : university.getUsers()) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}