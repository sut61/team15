package com.example.lab.Repository;

import com.example.lab.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findByhospital(String hospital);
}

