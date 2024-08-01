package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "Id should not be Empty!")
    private int id;

    @NotEmpty(message = "Name should not be Empty!")
    private String name;


    @NotNull(message = "Salary should not be Empty!")
   private int salary;
}
