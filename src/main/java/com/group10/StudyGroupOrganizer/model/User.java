package com.group10.StudyGroupOrganizer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userTble")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String email;
    private String address;
    private int age;
    private int phone;
    private String username;
    private String password;
}
