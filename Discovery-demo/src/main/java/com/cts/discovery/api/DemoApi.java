package com.cts.discovery.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoApi {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/ping")
    public String ping() {
        return "Hello World";
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setId(Integer.valueOf((int) Math.random()));
        students.add(student);
        System.out.println(students);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Integer id, @RequestBody Student student) {

        return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Integer id) {

        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable("studentId") Integer id) {

        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getAStudent(@PathVariable("studentId") Integer id) {

        return new ResponseEntity<Student>(HttpStatus.OK);
    }
}
