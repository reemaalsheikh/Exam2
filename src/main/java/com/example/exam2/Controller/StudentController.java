package com.example.exam2.Controller;

import com.example.exam2.Api.ApiResponse;
import com.example.exam2.Model.Student;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


//● Get all students
    @GetMapping("/get")
 public ResponseEntity getAllStudents (){
  return ResponseEntity.status(200).body(studentService.getAllStudents());
 }

//● Add new student
    @PostMapping("/add")
 public ResponseEntity addStudent(@Valid @RequestBody Student student , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
 }

//● update student
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@Valid @RequestBody Student student , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = studentService.updateStudent(id, student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

//● delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDeleted = studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

//● Create an endpoint that takes a student name and returns one student . >> object
    @GetMapping("/gets/{name}")
   public ResponseEntity getStudentByName(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        if(student == null){
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(student);
    }
//● Create an endpoint that takes a major and returns all students who have this major. >> arraylist

    @GetMapping("/get/student/{major}")
    public ResponseEntity getStudentsbyMajor(@PathVariable String major){
        ArrayList<Student> studentsmajor = studentService.getStudentsByMajor(major);

        if(studentsmajor.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(studentsmajor);

    }




}
