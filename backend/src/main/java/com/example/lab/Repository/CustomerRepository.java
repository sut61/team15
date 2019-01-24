package com.example.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.lab.Entity.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByfirstname(String firstname);

    @Query("select t from Customer t where t.firstname =:fName and t.lastname = :lName")
    Customer findByFullName(@Param("fName") String FName, @Param("lName") String LName);
}
