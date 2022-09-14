package com.example.demo.userAPI.persistance.entities.jwt;

import com.example.demo.userAPI.persistance.entities.Reservation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dh_usuario")
public class UserEntity {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cedula")
    private String document;

    @Column(name = "correo")
    private String email;

    @Column(name = "clave")
    private String password;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    // role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Reservation> reservations = new HashSet<>();

}
