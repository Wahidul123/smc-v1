package com.sameeha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "faqs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(columnDefinition = "LONGTEXT")
    private String answer;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Boolean isFeatured = false;

    @Column(nullable = false)
    private LocalDateTime lastUpdated = LocalDateTime.now();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}