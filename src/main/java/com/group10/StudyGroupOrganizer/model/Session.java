package com.group10.StudyGroupOrganizer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "sessionTble")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String sessionName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    @ManyToOne
    @JoinColumn(name = "group_id" , nullable = false)
    private Group group;
}
