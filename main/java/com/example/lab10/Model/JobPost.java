package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(15) unique not null")
    @NotNull(message = "title can not be null")
    @Size(min = 4, message = "title must be 4 or more characters")
    private String title;

    @Column(columnDefinition = "varchar(30) not null")
    @NotNull(message = "descreption can not be null")
    private String descreption;

    @Column(columnDefinition = "varchar(20) unique not null")
    @NotNull(message = "location can not be null")
    private String location;

    @Column(columnDefinition = "varchar(15) not null")
    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be a positive number")
    private Double salary;

    @Column(columnDefinition = "date")
    @Temporal(TemporalType.DATE)
    private Date postingDate = new Date();
}
