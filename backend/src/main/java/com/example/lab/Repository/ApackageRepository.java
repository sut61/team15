package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Apackage;

@RepositoryRestResource
public
interface ApackageRepository extends JpaRepository<Apackage, Long> {
    Apackage findByname(String name);
}

