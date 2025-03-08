package com.example.oci_microservice.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String First_name;
    private String Last_name;
    private String email;
    private String StudentID;
}