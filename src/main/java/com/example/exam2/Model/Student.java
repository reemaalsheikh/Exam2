package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "Id should not be Null!")
    private int id;

    @NotEmpty(message = "Name should not be Empty!")
    private String name;

    @NotNull(message = "Age should nor be Null!")
    private int age;

    @NotEmpty(message = "Major should not be Empty!")
    private String major;
}
