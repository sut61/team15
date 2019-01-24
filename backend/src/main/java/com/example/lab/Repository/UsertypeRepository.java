package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Usertype;

@RepositoryRestResource
public interface UsertypeRepository extends JpaRepository<Usertype, Long> {
    Usertype findBytype(String type);
}
