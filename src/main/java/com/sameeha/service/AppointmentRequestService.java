package com.sameeha.service;

import com.sameeha.entity.AppointmentRequest;
import com.sameeha.repository.AppointmentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentRequestService {

    @Autowired
    private AppointmentRequestRepository appointmentRequestRepository;

    public List<AppointmentRequest> getAllAppointments() {
        return appointmentRequestRepository.findAll();
    }

    public Optional<AppointmentRequest> getAppointmentById(Long id) {
        return appointmentRequestRepository.findById(id);
    }

    public AppointmentRequest createAppointment(AppointmentRequest appointment) {
        return appointmentRequestRepository.save(appointment);
    }

    public AppointmentRequest updateAppointment(Long id, AppointmentRequest appointmentDetails) {
        Optional<AppointmentRequest> appointment = appointmentRequestRepository.findById(id);
        if (appointment.isPresent()) {
            AppointmentRequest existingAppointment = appointment.get();
            existingAppointment.setPatientName(appointmentDetails.getPatientName());
            existingAppointment.setEmailAddress(appointmentDetails.getEmailAddress());
            existingAppointment.setPhoneNumber(appointmentDetails.getPhoneNumber());
            existingAppointment.setSelectedDoctor(appointmentDetails.getSelectedDoctor());
            existingAppointment.setPreferredDate(appointmentDetails.getPreferredDate());
            existingAppointment.setPreferredTime(appointmentDetails.getPreferredTime());
            return appointmentRequestRepository.save(existingAppointment);
        }
        return null;
    }

    public void deleteAppointment(Long id) {
        appointmentRequestRepository.deleteById(id);
    }
}