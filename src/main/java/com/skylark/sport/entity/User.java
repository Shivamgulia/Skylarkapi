package com.skylark.sport.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    private String role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    //TODO figure out what to do with password
    @Override
    public String getPassword()   {
        try {
            throw new Exception("NO PASSWORD FIELD");
        } catch
            (Exception e) {
        }
        return "";
    }

    @Override
    public String getUsername() {
        return number;
    }


}