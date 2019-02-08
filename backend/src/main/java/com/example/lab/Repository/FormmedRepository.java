package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Formmed;

@RepositoryRestResource
public
interface FormmedRepository extends JpaRepository<Formmed, Long> {
    Formmed findByname(String name);
}

