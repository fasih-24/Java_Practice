package com.faiz.springboot.controller;

import com.faiz.springboot.beans.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("getStudent")
    public Student getStudent(){
        return new Student(1,"Faiz", "AITH");
    }

    @GetMapping("getAllStudent")
    public List<Student> getAllStudent(){
         List<Student> students = new ArrayList<>();
         students.add(new Student(1,"faizan", "MIC"));
         students.add(new Student(2, "Fasih", "MPIC"));
         students.add(new Student(3, "Fasihullah", "MPIC"));
        return students;
    }

    @GetMapping("getStudent/{id}")
    public Student getStudentPathVar(@PathVariable long id){
        return new Student(id,"Faiz", "AITH");
    }
    @GetMapping("getStudent/query")
    public Student getStudentReqParam(@RequestParam long id){
        return new Student(id,"Faiz", "AITH");
    }
    @PostMapping("students/create")
    public Student create(@RequestBody Student s){
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getCollege());
        return s;
    }
}
