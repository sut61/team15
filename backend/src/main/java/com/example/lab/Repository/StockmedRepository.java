package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Stockmed;

@RepositoryRestResource
public interface StockmedRepository extends JpaRepository<Stockmed, Long> {
    Stockmed findByname(String name);
}
