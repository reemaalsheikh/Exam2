package com.example.exam2.Controller;

import com.example.exam2.Api.ApiResponse;
import com.example.exam2.Model.Student;
import com.example.exam2.Model.Teacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {
    private final TeacherService teacherService;

//● Get all teachers
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

//● Add new teacher
@PostMapping("/add")
public ResponseEntity addTeacher (@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
          String message= errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added Successfully"));

}

//● update teacher
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher (@PathVariable int id ,@Valid @RequestBody Teacher teacher , Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       boolean isUpdated = teacherService.updateTeacher(id,teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher Updated Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found"));
    }

//● delete teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher (@PathVariable int id){
        boolean isDeleted = teacherService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher Deleted Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found"));
    }

//● Create an endpoint that takes a teacher id and returns one teacher . >> obj
    @GetMapping("get/teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable int id){
        Teacher teacher = teacherService.getTeacherByid(id);
        if(teacher == null){
            return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found"));
        }
        return ResponseEntity.status(200).body(teacher);

    }
//● Create an endpoint that takes a salary and return all teachers who have this salary or above . >> arraylist
@GetMapping("/getAll/{salary}")
public ResponseEntity getallSalary (@PathVariable int salary){
    ArrayList <Teacher> teacherSalary = teacherService.getTeacherBySalary(salary);

    if(teacherSalary == null){
        return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found"));
    }

    return ResponseEntity.status(200).body(teacherSalary);


}

}
