package com.sameeha.controller;

import com.sameeha.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/faq")
public class FAQController {
    
    @Autowired
    private FAQService faqService;
    
    @GetMapping
    public String listFAQs(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search,
            Model model) {
        if (category != null && !category.isEmpty()) {
            model.addAttribute("faqs", faqService.getFAQsByCategory(category));
        } else if (search != null && !search.isEmpty()) {
            model.addAttribute("faqs", faqService.searchFAQs(search));
        } else {
            model.addAttribute("faqs", faqService.getAllFAQs());
        }
        return "faq/list";
    }
}