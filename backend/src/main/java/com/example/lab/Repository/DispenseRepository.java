package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Dispense;

@RepositoryRestResource
public interface DispenseRepository extends JpaRepository<Dispense, Long> {
    Dispense findByidlabel(String idlabel);
    Dispense findBynumberpill(Integer numberpill);
    Dispense findBybenefit(String benefit);
}
