package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Reserve;

@RepositoryRestResource
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    //Reserve findByreserveConfirm(boolean reserveConfirm);
}
