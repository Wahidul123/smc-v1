package com.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getAllDoctors() {
        // Logic to get all doctors
        return null;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        // Logic to get a doctor by ID
        return null;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        // Logic to create a new doctor
        return null;
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        // Logic to update a doctor
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        // Logic to delete a doctor
    }
}