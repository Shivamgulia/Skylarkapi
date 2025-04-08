package com.skylark.sport.service;

import com.skylark.sport.entity.Student;

public interface StudentService {

    Student findStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudentById(Long id);

    Student updateStudent(Long id, Student student);

}
