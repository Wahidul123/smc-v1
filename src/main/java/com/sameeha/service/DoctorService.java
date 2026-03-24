package com.sameeha.service;

import com.sameeha.entity.Doctor;
import com.sameeha.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public List<Doctor> searchDoctors(String name) {
        return doctorRepository.findByDoctorNameContainingIgnoreCase(name);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            Doctor existingDoctor = doctor.get();
            existingDoctor.setDoctorName(doctorDetails.getDoctorName());
            existingDoctor.setSpecialty(doctorDetails.getSpecialty());
            existingDoctor.setExperienceYears(doctorDetails.getExperienceYears());
            existingDoctor.setProfileImage(doctorDetails.getProfileImage());
            existingDoctor.setBiography(doctorDetails.getBiography());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}