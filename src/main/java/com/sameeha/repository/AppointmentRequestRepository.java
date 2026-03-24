package com.sameeha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface AppointmentRequestRepository extends JpaRepository<AppointmentRequest, Long> {
    List<AppointmentRequest> findByDate(Date date);
    List<AppointmentRequest> findByEmail(String email);
    List<AppointmentRequest> findByDoctorName(String doctorName);
}