package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Type;

@RepositoryRestResource
public
interface TypeRepository extends JpaRepository<Type, Long> {
    Type findBynameType(String nameType);
}

