package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Drugtype;

@RepositoryRestResource
public
interface DrugtypeRepository extends JpaRepository<Drugtype, Long> {
    Drugtype findByname(String name);
}
