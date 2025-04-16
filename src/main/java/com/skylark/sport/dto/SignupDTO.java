package com.skylark.sport.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupDTO {


    private String name;

    private String email;

    private String password;

    private String role;

    private Long coachId;


}
