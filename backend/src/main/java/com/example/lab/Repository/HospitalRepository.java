package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Hospital;

@RepositoryRestResource
public
interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findByhospital(String hospital);
}

