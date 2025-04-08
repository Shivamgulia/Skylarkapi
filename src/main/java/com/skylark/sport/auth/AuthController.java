package com.skylark.sport.auth;


import com.skylark.sport.dto.LoginDTO;
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

        Optional<User> foundUser = userService.findByEmail(user.getEmail());

        if (foundUser.isPresent()) {
            return null;
        } else {

            User newUser = new User();

            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setRole(user.getRole());

            userService.save(newUser);

            System.out.println("New User Created \n" + newUser);

            return "User Created";

        }


    }

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginDTO loginDTO) {

        User user = userService.findByUsername(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(new LoginRes("Login in Success",token, user.getId(), user.getEmail()));
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
}