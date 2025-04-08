package com.skylark.sport.auth;

import com.skylark.sport.service.AttendanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skylark.sport.dto.AttendanceDTO;
import com.skylark.sport.entity.Attendance;
import com.skylark.sport.service.AttendanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AttendanceController {



    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/attendances")
    public Long createAttendance(@RequestBody AttendanceDTO attendanceDto) {
        Attendance newAttendance = attendanceService.saveAttendance(attendanceDto);
        return newAttendance.getId();
    }

    @GetMapping("/studentattendances/{studentId}")
    public List<Attendance> getAttendanceByStudentAndMonth(
            @PathVariable("studentId") Long studentId,
            @RequestParam(name = "month", required = true) Optional<Integer> month,
            @RequestParam(name = "year", required = true) Optional<Integer> year) {
        if (month.isPresent() && year.isPresent()) {
            return attendanceService.getAttendanceByStudentAndMonth(studentId, month.get(), year.get());
        }
        throw new IllegalArgumentException("Month and Year are required");
    }
}
