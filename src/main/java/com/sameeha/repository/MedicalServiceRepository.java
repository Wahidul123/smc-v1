package com.sameeha.repository;

import com.sameeha.entity.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalService, Long> {
    List<MedicalService> findByCategory(String category);
    List<MedicalService> findByServiceNameContaining(String serviceName);
}