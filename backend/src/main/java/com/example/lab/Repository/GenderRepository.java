package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Gender;

@RepositoryRestResource
public
interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findBygender(String gender);
}
