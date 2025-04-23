package com.student;

import java.util.Map;

public class Student {
    private int studentId;
    private String fullName;
    private String dob;
    private String email;
    private String phoneNumber;
    private String address;
    private String parentName;
    private String parentPhoneNumber;
    private String coursesEnrolled;
    private String enrollmentDate;
    private Map <String, String> grades;

    public Student(int studentId, String fullName, String dob, String email, String phoneNumber, String address,
                   String parentName, String parentPhoneNumber, String coursesEnrolled, String enrollmentDate, Map <String, String> grades) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.parentName = parentName;
        this.parentPhoneNumber = parentPhoneNumber;
        this.coursesEnrolled = coursesEnrolled;
        this.enrollmentDate = enrollmentDate;
        this.grades = grades;
    }

    // Getter
    public int getStudentId() {return studentId;}
    public String getFullName() {return fullName;}
    public String getDob() {return dob;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getAddress() {return address;}
    public String getParentName() {return parentName;}
    public String getParentPhoneNumber() {return parentPhoneNumber;}
    public String getCoursesEnrolled() {return coursesEnrolled;}
    public String getEnrollmentDate() {return enrollmentDate;}
    public Map <String, String> getGrades() {return grades;}

    // Setter
    public void setStudentId(int studentId) {this.studentId = studentId;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public void setDob(String dob) {this.dob = dob;}
    public void setEmail(String email) {this.email = email;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setAddress(String address) {this.address = address;}
    public void setParentName(String parentName) {this.parentName = parentName;}
    public void setParentPhoneNumber(String parentPhoneNumber) {this.parentPhoneNumber = parentPhoneNumber;}
    public void setCoursesEnrolled(String coursesEnrolled) {this.coursesEnrolled = coursesEnrolled;}
    public void setEnrollmentDate(String enrollmentDate) {this.enrollmentDate = enrollmentDate;}
    public void setGrades(Map <String, String> grades) {this.grades = grades;}

    public void displayStudentDetails() {
        System.out.println("\nStudent ID                  : " + studentId);
        System.out.println("Full Name                   : " + fullName);
        System.out.println("Date of Birth               : " + dob);
        System.out.println("Email                       : " + email);
        System.out.println("Phone Number                : " + phoneNumber);
        System.out.println("Address                     : " + address);
        System.out.println("Parent's Name               : " + parentName);
        System.out.println("Parent's Phone Number       : " + parentPhoneNumber);
        System.out.println("Courses Enrolled            : " + coursesEnrolled);
        System.out.println("Enrollment Date             : " + enrollmentDate);

        // Display grades as a formatted list
        System.out.println("Grades:");
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println("- " + entry.getKey() + "        : " + entry.getValue());
        }
        System.out.println("--------------------------------------------------------------");
    }
}

