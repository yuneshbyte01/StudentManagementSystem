package com.student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static StudentManager manager = new StudentManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Display menu
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void displayMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            String dob = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter guardian name: ");
            String guardianName = scanner.nextLine();
            System.out.print("Enter guardian phone number: ");
            String guardianPhone = scanner.nextLine();
            System.out.print("Enter subjects (comma separated): ");
            String subjects = scanner.nextLine();
            System.out.print("Enter admission date (dd/MM/yyyy): ");
            String admissionDate = scanner.nextLine();

            System.out.println("Enter grades for subjects:");
            String[] subjectArray = subjects.split(",");
            Map<String, String> grades = new HashMap<>();
            for (String subject : subjectArray) {
                subject = subject.trim();
                System.out.print("Grade for " + subject + ": ");
                String grade = scanner.nextLine();
                grades.put(subject, grade);
            }

            Student student = new Student(id, name, dob, email, phone, address, guardianName, guardianPhone, subjects, admissionDate, grades);
            manager.addStudent(student);
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public static void displayAllStudents() {
        System.out.println("All students:");
        for (Student student : manager.getAllStudents()) {
            student.displayStudentDetails();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        Student student = manager.getStudent(id);
        if (student != null) {
            student.displayStudentDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void updateStudent() {
        System.out.print("Enter the ID of the student to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = manager.getStudent(id); // Assumes you have this method in StudentManager
        if (student == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.println("Updating student: " + student.getFullName());

        System.out.print("Enter new name (press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setFullName(name);

        System.out.print("Enter new date of birth (press Enter to keep current): ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()) student.setDob(dob);

        System.out.print("Enter new email (press Enter to keep current): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) student.setEmail(email);

        System.out.print("Enter new phone number (press Enter to keep current): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) student.setPhoneNumber(phone);

        System.out.print("Enter new address (press Enter to keep current): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) student.setAddress(address);

        System.out.print("Enter new guardian name (press Enter to keep current): ");
        String guardianName = scanner.nextLine();
        if (!guardianName.isEmpty()) student.setParentName(guardianName);

        System.out.print("Enter new guardian phone number (press Enter to keep current): ");
        String guardianPhone = scanner.nextLine();
        if (!guardianPhone.isEmpty()) student.setParentPhoneNumber(guardianPhone);

        System.out.print("Enter new subjects (comma separated) (press Enter to keep current): ");
        String subjects = scanner.nextLine();
        if (!subjects.isEmpty()) {
            student.setCoursesEnrolled(subjects);

            System.out.println("Enter new grades for subjects:");
            Map<String, String> newGrades = new HashMap<>();
            for (String subject : subjects.split(",")) {
                subject = subject.trim();
                System.out.print("Grade for " + subject + ": ");
                String grade = scanner.nextLine();
                newGrades.put(subject, grade);
            }
            student.setGrades(newGrades);
        }  else {
            System.out.print("Do you want to update grades? (yes/no): ");
            String updateGrades = scanner.nextLine().trim().toLowerCase();
            if (updateGrades.equals("yes")) {
                Map<String, String> currentGrades = student.getGrades();
                Map<String, String> updatedGrades = new HashMap<>(currentGrades);

                for (String subject : currentGrades.keySet()) {
                    System.out.print("Enter new grade for " + subject + " (press Enter to keep current '" + currentGrades.get(subject) + "'): ");
                    String newGrade = scanner.nextLine();
                    if (!newGrade.isEmpty()) {
                        updatedGrades.put(subject, newGrade);
                    }
                }

                student.setGrades(updatedGrades);
            }
        }

        System.out.print("Enter new admission date (press Enter to keep current): ");
        String admissionDate = scanner.nextLine();
        if (!admissionDate.isEmpty()) student.setEnrollmentDate(admissionDate);

        System.out.println("Student updated successfully!");
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        manager.removeStudent(id);
        System.out.println("Student deleted successfully!");
    }
}
