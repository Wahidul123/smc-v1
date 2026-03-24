package com.sameeha.service;

import com.sameeha.entity.ContactSubmission;
import com.sameeha.repository.ContactSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactSubmissionService {
    
    @Autowired
    private ContactSubmissionRepository contactRepository;
    
    public List<ContactSubmission> getAllSubmissions() {
        return contactRepository.findAll();
    }
    
    public Optional<ContactSubmission> getSubmissionById(Long id) {
        return contactRepository.findById(id);
    }
    
    public List<ContactSubmission> getSubmissionsByEmail(String email) {
        return contactRepository.findByEmail(email);
    }
    
    public ContactSubmission saveSubmission(ContactSubmission submission) {
        return contactRepository.save(submission);
    }
    
    public void deleteSubmission(Long id) {
        contactRepository.deleteById(id);
    }
}