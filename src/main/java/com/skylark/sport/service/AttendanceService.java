package com.skylark.sport.service;

import com.skylark.sport.dto.AttendanceDTO;
import com.skylark.sport.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> getAttendanceByStudentAndMonth(Long studentId, int month, int year);

    Attendance saveAttendance(AttendanceDTO attendanceDTO);
}