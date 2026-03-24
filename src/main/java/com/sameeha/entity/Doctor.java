package com.sameeha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private Integer experienceYears;

    @Column(columnDefinition = "LONGTEXT")
    private String profileImage;

    @Column(columnDefinition = "LONGTEXT")
    private String biography;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}