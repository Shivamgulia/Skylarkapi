package com.skylark.sport.auth;


import com.skylark.sport.dto.LoginDTO;
import com.skylark.sport.dto.SignupDTO;
import com.skylark.sport.entity.Coach;
import com.skylark.sport.entity.Student;
import com.skylark.sport.entity.User;
import com.skylark.sport.service.CoachService;
import com.skylark.sport.service.StudentService;
import com.skylark.sport.service.UserService;
import com.skylark.sport.util.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



//TODO add status code and proper responses and also return jwt from verify otp



@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    public JWTUtil jwtUtil;

    @Autowired
    public UserService userService;


    @Autowired
    private CoachService coachService;

    @Autowired
    private StudentService studentService;


    @PostMapping("/signup/coach")
    public String signupCoach(@RequestBody SignupDTO user) {

        Optional<User> foundUser = userService.findByEmail(user.getEmail());

        if (foundUser.isPresent()) {
            return null;
        } else {

            User newUser = new User();

            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setRole("COACH");
            userService.save(newUser);

            Coach newCoach = new Coach();

            newCoach.setEmail(user.getEmail());

            coachService.saveCoach(newCoach);

            System.out.println("New User Created \n" + newUser);

            return "User Created";

        }


    }
    @PostMapping("/signup/student")
    public String signupStudent(@RequestBody SignupDTO user) {

        Optional<User> foundUser = userService.findByEmail(user.getEmail());

        if (foundUser.isPresent()) {
            return "User Already Present";
        } else {

            User newUser = new User();

            Coach tempCoach  = coachService.findCoachById(user.getCoachId());

            if(tempCoach == null) return "Coach Not Found";

            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setRole("STUDENT");
            userService.save(newUser);

            Student newStudent = new Student();

            newStudent.setEmail(user.getEmail());
            newStudent.setCoach(tempCoach);

            studentService.saveStudent(newStudent);

            System.out.println("New User Created \n" + newUser);

            return "Student Created";

        }


    }

    @PostMapping("/login/coach")
    public LoginRes loginCoach(@RequestBody LoginDTO loginDTO) {

        User user = userService.findByUsername(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {

            Coach coach = coachService.findByEmail(user.getEmail());
            if(coach == null)
            {
                LoginRes newLoginRes = new LoginRes();
                newLoginRes.setMessage("Student Not Found");
                return newLoginRes;
            }

            String token = jwtUtil.generateToken(user.getEmail());
            return new LoginRes("Login in Success",token, user.getId(), user.getEmail(), coach, null);
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }

    @PostMapping("/login/student")
    public LoginRes loginStudent(@RequestBody LoginDTO loginDTO) {

        User user = userService.findByUsername(loginDTO.getEmail());
        System.out.println(user);
        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {

            Student student = studentService.findByEmail(user.getEmail());
            System.out.println(student);
            if(student == null)
            {
                LoginRes newLoginRes = new LoginRes();
                newLoginRes.setMessage("Student Not Found");
                return newLoginRes;
            }

            String token = jwtUtil.generateToken(user.getEmail());
            return new LoginRes("Login in Success",token, user.getId(), user.getEmail(), null, student);
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }

}



@AllArgsConstructor
@NoArgsConstructor
@Data
class LoginRes {
    private String message;
    private String token;
    private Integer userId;
    private String email;
    private Coach coach;
    private Student student;
}