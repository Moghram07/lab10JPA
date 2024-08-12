package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Name cannot be null")
    @Size(min = 4, message = "Name must be more than 4 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only characters")
    private String name;

    @Column(columnDefinition = "varchar(25) unique not null")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Must be a valid email format")
    private String email;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Age cannot be null")
    @Min(value = 22, message = "Age must be more than 21")
    private Integer age;

    @Column(columnDefinition = "varchar (10) not null")
    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER' only")
    private String role;

}
