package com.sameeha.service;

import com.sameeha.entity.FAQ;
import com.sameeha.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FAQService {
    
    @Autowired
    private FAQRepository faqRepository;
    
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }
    
    public Optional<FAQ> getFAQById(Long id) {
        return faqRepository.findById(id);
    }
    
    public List<FAQ> getFAQsByCategory(String category) {
        return faqRepository.findByCategory(category);
    }
    
    public List<FAQ> getFeaturedFAQs() {
        return faqRepository.findByIsFeaturedTrue();
    }
    
    public List<FAQ> searchFAQs(String question) {
        return faqRepository.findByQuestionContainingIgnoreCase(question);
    }
    
    public FAQ saveFAQ(FAQ faq) {
        return faqRepository.save(faq);
    }
    
    public void deleteFAQ(Long id) {
        faqRepository.deleteById(id);
    }
}
