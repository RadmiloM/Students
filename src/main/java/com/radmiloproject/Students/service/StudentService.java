package com.radmiloproject.Students.service;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(UUID uuid){
        return studentRepository.findById(uuid).get();
    }

    public List<Student> fetchAllStudents(){
        return studentRepository.findAll();
    }


}
