package com.skylark.sport.service.Impl;
import com.skylark.sport.dto.AttendanceDTO;
import com.skylark.sport.entity.Attendance;
import com.skylark.sport.entity.Student;
import com.skylark.sport.repository.AttendanceRepository;
import com.skylark.sport.service.AttendanceService;
import com.skylark.sport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private StudentService studentService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAttendanceByStudentAndMonth(Long studentId, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return attendanceRepository.findByStudentIdAndDateBetween(studentId, startDate, endDate);
    }


    @Override
    public Attendance saveAttendance(AttendanceDTO attendanceDTO) {
        Student student = studentService.findStudentById(attendanceDTO.getStudentId());
        if(student == null) {
            throw new IllegalArgumentException("Student not found");
        }

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(attendanceDTO.getDate());
        return attendanceRepository.save(attendance);
    }
}