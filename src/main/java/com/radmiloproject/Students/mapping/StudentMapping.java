package com.radmiloproject.Students.mapping;

import com.radmiloproject.Students.entity.Student;
import com.radmiloproject.Students.modal.StudentModal;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudentMapping {


    public Student mapToEntity(StudentModal studentModal){
        LocalDateTime currentTime = LocalDateTime.now();
        Student student = new Student();
        student.setFirstName(studentModal.getFirstName());
        student.setLastName(studentModal.getLastName());
        student.setPhoneNumber(studentModal.getPhoneNumber());
        student.setIndexNumber(studentModal.getIndexNumber());
        student.setCreatedTime(currentTime);
        student.setUpdatedTime(currentTime);
        return student;
    }

    public StudentModal mapToDTO(Student student){
        StudentModal studentModal = new StudentModal();
        studentModal.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setIndexNumber(student.getIndexNumber());
        student.setPhoneNumber(student.getPhoneNumber());
        return studentModal;
    }


}
