package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Title;

@RepositoryRestResource
public
interface TitleRepository extends JpaRepository<Title, Long> {
    Title findByname(String name);
}

