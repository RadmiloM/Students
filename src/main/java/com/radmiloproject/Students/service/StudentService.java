package com.radmiloproject.Students.service;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }


}
