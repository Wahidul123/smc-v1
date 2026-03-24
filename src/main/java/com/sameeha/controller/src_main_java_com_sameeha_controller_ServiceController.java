package com.sameeha.controller;

import com.sameeha.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/services")
public class ServiceController {
    
    @Autowired
    private MedicalServiceService medicalServiceService;
    
    @GetMapping
    public String listServices(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search,
            Model model) {
        if (category != null && !category.isEmpty()) {
            model.addAttribute("services", medicalServiceService.getServicesByCategory(category));
        } else if (search != null && !search.isEmpty()) {
            model.addAttribute("services", medicalServiceService.searchServices(search));
        } else {
            model.addAttribute("services", medicalServiceService.getAllServices());
        }
        return "services/list";
    }
    
    @GetMapping("/{id}")
    public String viewService(@PathVariable Long id, Model model) {
        medicalServiceService.getServiceById(id).ifPresent(service -> {
            model.addAttribute("service", service);
        });
        return "services/detail";
    }
}