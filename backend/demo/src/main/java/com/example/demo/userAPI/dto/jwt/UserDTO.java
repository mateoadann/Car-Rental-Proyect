package com.example.demo.userAPI.dto.jwt;
import com.example.demo.userAPI.persistance.entities.jwt.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String document;

    private String email;

    private String password;

    private String name;

    private String lastName;
    // role
    private RoleEntity role;
}
