package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.Student;
import com.skylark.sport.repository.StudentRepository;
import com.skylark.sport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        List<Student> students = studentRepository.findByEmail(email);
        if(students.size() < 1) {
            return null;
        }
        return students.get(0);
    }
}
