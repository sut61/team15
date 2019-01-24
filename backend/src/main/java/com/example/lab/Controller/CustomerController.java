package com.example.lab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    public CustomerController(CustomerRepository customerRepository,
                              TypeRepository typeRepository,
                              GenderRepository genderRepository,
                              ProvinceRepository provinceRepository) {
        this.customerRepository = customerRepository;
        this.typeRepository = typeRepository;
        this.genderRepository = genderRepository;
        this.provinceRepository = provinceRepository;
    }

    //customer
    @GetMapping(path = "/Customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Customer> getCustomer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Customer/{CustomerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getOneCustomer(@PathVariable Long customerId){ return customerRepository.findById(customerId).get();
    }
    //type
    @GetMapping(path = "/Type", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Type> getType() {
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Type/{typeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Type getOneType(@PathVariable long typeId){
        return typeRepository.findById(typeId).get();
    }




    @PostMapping(path ="/customer/{firstnameInput}/{lastnameInput}/{idcardInput}/" +
            "{genderNameSelect}/{provinceNameSelect}/{nameTypeSelect}")
    public Customer newCustomer(@PathVariable String firstnameInput , @PathVariable String lastnameInput,
                                @PathVariable String idcardInput, @PathVariable String genderNameSelect,
                                @PathVariable String provinceNameSelect, @PathVariable String nameTypeSelect
                                ) {
        Customer c = new Customer();
        Gender gender = genderRepository.findBygender(genderNameSelect);
        System.out.print(gender);
        Province province = provinceRepository.findByname(provinceNameSelect);
        System.out.print(province);
        Type type = typeRepository.findBynameType(nameTypeSelect);
        System.out.print(province);

        c.setFirstname(firstnameInput);
        c.setLastname(lastnameInput);
        c.setIdcard(idcardInput);
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);


        return customerRepository.save(c);
    }
    @DeleteMapping(path ="customer/{customerId}")
    void deleteCustomer(@PathVariable Long customerId){
       customerRepository.deleteById(customerId);
    }
}
