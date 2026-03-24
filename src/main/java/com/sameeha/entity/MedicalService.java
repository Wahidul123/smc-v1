package com.sameeha.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "medical_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String serviceName;
    @Column(nullable = false)
    private String shortDescription;
    @Column(columnDefinition = "LONGTEXT")
    private String detailedDescription;
    @Column(columnDefinition = "LONGTEXT")
    private String serviceImage;
    @Column(nullable = false)
    private String category;
    @Column(columnDefinition = "LONGTEXT")
    private String preparationInstructions;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();
    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}