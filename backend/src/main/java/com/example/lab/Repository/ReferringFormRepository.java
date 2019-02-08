package com.example.lab.Repository;

import com.example.lab.Entity.ReferringForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReferringFormRepository extends JpaRepository<ReferringForm, Long> {
    ReferringForm findBytel(String tel);
}
