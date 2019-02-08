package com.example.lab.Repository;

import com.example.lab.Entity.Treatmentrights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentrightsRepository extends JpaRepository<Treatmentrights, Long> {
    Treatmentrights findBytreatment(String treatment);
}