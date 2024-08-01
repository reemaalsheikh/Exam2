package com.example.exam2.Service;

import com.example.exam2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

//● Get all students
 public ArrayList<Student> getAllStudents() {
     return students;
 }
//● Add new student
    public void addStudent(Student student) {
     students.add(student);
    }

//● update student
    public boolean updateStudent(int id, Student student) {
     for (int i = 0; i < students.size(); i++) {
         if (students.get(i).getId() == id) {
             students.set(i, student);
             return true;
         }
     }
     return false;
    }

//● delete student
    public boolean deleteStudent(int id) {
     for (int i = 0; i < students.size(); i++) {
         if (students.get(i).getId() == id) {
             students.remove(i);
             return true;
         }
     }
     return false;
    }

//● Create an endpoint that takes a student name and returns one student . >> object
    public Student getStudentByName(String name) {
     for (int i = 0; i < students.size(); i++) {
         if (students.get(i).getName().equals(name)) {
             return students.get(i);
         }
     }
     return null;
    }


//● Create an endpoint that takes a major and returns all students who have this major. >> arraylist
    public ArrayList<Student> getStudentsByMajor (String major) {
     ArrayList<Student> studentsMajor = new ArrayList<>();
     for (int i = 0; i < students.size(); i++) {
         if (students.get(i).getMajor().equals(major)) {
             studentsMajor.add(students.get(i));
         }
     }
     return studentsMajor;
    }





}
