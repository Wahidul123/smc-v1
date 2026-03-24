package com.sameeha.controller;

import com.sameeha.entity.AppointmentRequest;
import com.sameeha.service.AppointmentRequestService;
import com.sameeha.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    
    @Autowired
    private AppointmentRequestService appointmentService;
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping
    public String bookAppointment(Model model) {
        model.addAttribute("appointment", new AppointmentRequest());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointment/book";
    }
    
    @PostMapping
    public String submitAppointment(AppointmentRequest appointment, Model model) {
        try {
            appointmentService.saveAppointment(appointment);
            model.addAttribute("success", "Appointment booked successfully!");
            return "redirect:/appointment?success=true";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to book appointment: " + e.getMessage());
            return "appointment/book";
        }
    }
}
