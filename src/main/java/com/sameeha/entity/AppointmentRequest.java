package com.sameeha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String selectedDoctor;

    @Column(nullable = false)
    private LocalDate preferredDate;

    @Column(nullable = false)
    private LocalTime preferredTime;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}