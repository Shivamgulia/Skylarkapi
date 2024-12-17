package com.skylark.sport.auth;


import com.skylark.sport.dto.SignupDTO;
import com.skylark.sport.entity.User;
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


    @PostMapping("/signup")
    public String signup(@RequestBody SignupDTO user) {

        Optional<User> foundUser = userService.findByNumber(user.getPhoneNumber());

        if (foundUser.isPresent()) {
            return null;
        } else {

            User newUser = new User();

            newUser.setNumber(user.getPhoneNumber());
            newUser.setName(user.getName());

            userService.save(newUser);

            System.out.println("New User Created \n" + newUser);

            return "User Created";

        }


    }

}



@AllArgsConstructor
@NoArgsConstructor
@Data
class LoginRes {
    private String message;
}