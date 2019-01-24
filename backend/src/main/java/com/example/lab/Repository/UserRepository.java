package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
        User findByfirstname(String firstname);
        User findByemail(String email);
        User findByType(String type);
        User findBypassword(String password);
}
