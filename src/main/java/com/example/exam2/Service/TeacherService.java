package com.example.exam2.Service;

import com.example.exam2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

//● Get all teachers
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
//● Add new teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

//● update teacher
    public boolean updateTeacher (int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

//● delete teacher
    public boolean deleteTeacher (int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

//● Create an endpoint that takes a teacher id and returns one teacher . >> obj
    public Teacher getTeacherByid (int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }

//● Create an endpoint that takes a salary and return all teachers who have this salary or above .>> arraylist
    public ArrayList<Teacher> getTeacherBySalary (int salary) {
        ArrayList<Teacher> teacherbySalary = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getSalary() >= salary) {
                teacherbySalary.add(teachers.get(i));
            }
        }
        return teacherbySalary;
    }





}
