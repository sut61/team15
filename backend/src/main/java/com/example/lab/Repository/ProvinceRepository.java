package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Province;

@RepositoryRestResource
public
interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByname(String name);
}

