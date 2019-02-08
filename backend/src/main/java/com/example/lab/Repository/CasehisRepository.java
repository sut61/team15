package com.example.lab.Repository;

import com.example.lab.Entity.Casehis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

    public interface CasehisRepository extends JpaRepository<Casehis, Long> {
        Casehis findBycasehis(String casehis);

}
