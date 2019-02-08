package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Instruction;

@RepositoryRestResource
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    Instruction findBytakepill(String takepill);
}
