package com.example.lab.Repository;

import com.example.lab.Entity.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BloodGroupRepository extends JpaRepository<BloodGroup, Long> {
    BloodGroup findByNameGroup(String nameGroup);
}
