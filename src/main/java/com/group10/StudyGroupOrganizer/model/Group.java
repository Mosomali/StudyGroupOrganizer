package com.group10.StudyGroupOrganizer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "groupTble")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private String subject;

    private String description;
    private LocalDateTime dateCreated;
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;
}
