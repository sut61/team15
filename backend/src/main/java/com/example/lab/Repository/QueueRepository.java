package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Queue;

@RepositoryRestResource
public interface QueueRepository extends JpaRepository<Queue, Long> {
    Queue findByqueueNumber(String queueNumber);
}
