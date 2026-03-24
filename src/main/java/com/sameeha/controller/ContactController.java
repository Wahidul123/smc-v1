package com.sameeha.controller;

import com.sameeha.entity.ContactSubmission;
import com.sameeha.service.ContactSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    private ContactSubmissionService contactService;
    
    @GetMapping
    public String contactForm(Model model) {
        model.addAttribute("submission", new ContactSubmission());
        return "contact/form";
    }
    
    @PostMapping
    public String submitContact(ContactSubmission submission, Model model) {
        try {
            contactService.saveSubmission(submission);
            model.addAttribute("success", "Message sent successfully!");
            return "redirect:/contact?success=true";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send message: " + e.getMessage());
            return "contact/form";
        }
    }
}
