package com.radmiloproject.Students.controller;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.mapping.StudentMapping;
import com.radmiloproject.Students.modal.StudentModal;
import com.radmiloproject.Students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapping studentMapping;


    @PostMapping("/createStudent")
    public ResponseEntity<Void> createStudent(@RequestBody StudentModal studentModal) {
        Student student = studentMapping.mapToEntity(studentModal);
        studentService.createStudent(student);
        return ResponseEntity.ok().build();
    }
}
