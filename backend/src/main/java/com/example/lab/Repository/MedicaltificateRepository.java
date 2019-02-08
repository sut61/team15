package com.example.lab.Repository;

import com.example.lab.Entity.Medicaltificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicaltificateRepository extends JpaRepository<Medicaltificate, Long> {
    Medicaltificate findBylistorder(String listorder);
}

