package com.radmiloproject.Students.controller;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.mapping.StudentMapping;
import com.radmiloproject.Students.modal.StudentModal;
import com.radmiloproject.Students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentModal> getStudent(@PathVariable("id") UUID uuid){
        Student student = studentService.getStudent(uuid);
        StudentModal studentModal = studentMapping.mapToDTO(student);
        return ResponseEntity.ok(studentModal);
    }
}
