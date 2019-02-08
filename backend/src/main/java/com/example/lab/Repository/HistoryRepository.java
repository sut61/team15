package com.example.lab.Repository;



import com.example.lab.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface HistoryRepository extends JpaRepository<History, Long> {


}

