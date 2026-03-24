package com.sameeha.controller;

import com.sameeha.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping
    public String listDoctors(
            @RequestParam(required = false) String specialty,
            @RequestParam(required = false) String search,
            Model model) {
        if (specialty != null && !specialty.isEmpty()) {
            model.addAttribute("doctors", doctorService.getDoctorsBySpecialty(specialty));
        } else if (search != null && !search.isEmpty()) {
            model.addAttribute("doctors", doctorService.searchDoctors(search));
        } else {
            model.addAttribute("doctors", doctorService.getAllDoctors());
        }
        return "doctors/list";
    }
    
    @GetMapping("/{id}")
    public String viewDoctor(@PathVariable Long id, Model model) {
        doctorService.getDoctorById(id).ifPresent(doctor -> {
            model.addAttribute("doctor", doctor);
        });
        return "doctors/detail";
    }
}
