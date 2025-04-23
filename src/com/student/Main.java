package com.student;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager object
        StudentManager manager = new StudentManager();

        // Create sample students
        Student student1 = new Student(1, "Prakash Sharma", "15/03/2000", "prakash.sharma@example.com", "9800000001", "Kathmandu, Nepal", "Sita Sharma", "9840000001", "Mathematics, Science", "01/09/2018", Map.of("Mathematics", "A", "Science", "B+"));
        Student student2 = new Student(2, "Anjali Thapa", "22/05/1999", "anjali.thapa@example.com", "9800000002", "Pokhara, Nepal", "Ram Thapa", "9840000002", "English, History", "01/09/2018", Map.of("English", "A-", "History", "A"));
        Student student3 = new Student(3, "Rohit Koirala", "12/07/2001", "rohit.koirala@example.com", "9800000003", "Lalitpur, Nepal", "Maya Koirala", "9840000003", "Physics, Chemistry", "01/09/2019", Map.of("Physics", "B", "Chemistry", "A"));

        // Add students to manager
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        // List all students
        System.out.println("All students:");
        for (Student student : manager.getAllStudents()) {
            student.displayStudentDetails();
        }
    }
}
