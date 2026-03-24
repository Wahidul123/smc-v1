package com.sameeha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceService {

    @Autowired
    private MedicalServiceRepository medicalServiceRepository;

    // Create
    public MedicalService create(MedicalService medicalService) {
        return medicalServiceRepository.save(medicalService);
    }

    // Read
    public List<MedicalService> getAll() {
        return medicalServiceRepository.findAll();
    }

    public Optional<MedicalService> getById(Long id) {
        return medicalServiceRepository.findById(id);
    }

    // Update
    public MedicalService update(Long id, MedicalService medicalService) {
        medicalService.setId(id);
        return medicalServiceRepository.save(medicalService);
    }

    // Delete
    public void delete(Long id) {
        medicalServiceRepository.deleteById(id);
    }
}