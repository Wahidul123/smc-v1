package com.sameeha.controller;

import com.sameeha.service.DoctorService;
import com.sameeha.service.MedicalServiceService;
import com.sameeha.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private MedicalServiceService medicalServiceService;
    
    @Autowired
    private FAQService faqService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("services", medicalServiceService.getAllServices());
        model.addAttribute("featuredFaqs", faqService.getFeaturedFAQs());
        return "index";
    }
}