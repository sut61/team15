package com.example.lab.Repository;

import com.example.lab.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;

@RepositoryRestResource
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findBydate(Date date);
}
