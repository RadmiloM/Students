package com.radmiloproject.Students.service;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(UUID uuid) {
        return studentRepository.findById(uuid).get();
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(Student student, UUID uuid) {
        Student studentDB = studentRepository.findById(uuid).get();
        if (student.getFirstName() != null && !"".equals(student.getFirstName())) {
            studentDB.setFirstName(student.getFirstName());
        }
        if(student.getLastName() !=null && !"".equals(student.getLastName())){
            studentDB.setLastName(student.getLastName());
        }
        if(student.getIndexNumber() != null && !"".equals(student.getIndexNumber())){
            studentDB.setIndexNumber(student.getIndexNumber());
        }
        if(student.getPhoneNumber() != null && !"".equals(student.getPhoneNumber())){
            studentDB.setPhoneNumber(student.getPhoneNumber());
        }
        studentRepository.save(studentDB);

    }


}
