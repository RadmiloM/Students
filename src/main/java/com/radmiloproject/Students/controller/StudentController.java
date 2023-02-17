package com.radmiloproject.Students.controller;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.mapping.StudentMapping;
import com.radmiloproject.Students.modal.StudentModal;
import com.radmiloproject.Students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/findAllStudents")
    public ResponseEntity<List<StudentModal>> findAllStudents(){
        List<Student> students = studentService.fetchAllStudents();
        List<StudentModal> studentModals = studentMapping.mapToDTO(students);
        return ResponseEntity.ok(studentModals);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody StudentModal studentModal,@PathVariable("id") UUID uuid){
        Student student = studentMapping.mapToEntity(studentModal);
        studentService.updateStudent(student,uuid);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") UUID uuid){
        studentService.deleteStudentById(uuid);
        return ResponseEntity.ok().build();
    }

}
