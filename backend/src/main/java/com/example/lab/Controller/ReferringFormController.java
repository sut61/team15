package com.example.lab.Controller;

import com.example.lab.Entity.*;
import com.example.lab.Repository.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReferringFormController {
    @Autowired
    private ReferringFormRepository referringFormRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private BloodGroupRepository bloodGroupRepository;

    public ReferringFormController(ReferringFormRepository referringFormRepository,
                                   TypeRepository typeRepository,
                                   CustomerRepository customerRepository,
                                   DentistDataRepository dentistDataRepository,
                                   BloodGroupRepository bloodGroupRepository){
        this.referringFormRepository = referringFormRepository;
        this.typeRepository = typeRepository;
        this.customerRepository = customerRepository;
        this.dentistDataRepository = dentistDataRepository;
        this.bloodGroupRepository = bloodGroupRepository;
    }
    //appointment
    @GetMapping(path = "/ReferringForm",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReferringForm> getReferringForm(){
        return referringFormRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/ReferringForm/{ReferringFormId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReferringForm getOneReferringForm(@PathVariable Long appointmentId){
        return referringFormRepository.findById(appointmentId).get();
    }


    @GetMapping(path = "/Type/{TypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Type getOneType(@PathVariable Long typeId){
        return typeRepository.findById(typeId).get();
    }

    @GetMapping(path = "/BloodGroup",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BloodGroup> getBloodGroup(){
        return bloodGroupRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/BloodGroup/{BloodGroupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BloodGroup getOneBloodGroup(@PathVariable Long bloodGroupId){
        return bloodGroupRepository.findById(bloodGroupId).get();
    }



    @GetMapping(path = "/ReferringForm/{dateInput}/{customerNameSelect}/{dentistNameSelect}/{typeSelect}/{bloodGroupSelect}/{telInput}")
    public ReferringForm newReferringForm( @PathVariable Date dateInput,
                                       @PathVariable String customerNameSelect,
                                       @PathVariable String dentistNameSelect,
                                       @PathVariable String typeSelect,
                                           @PathVariable String bloodGroupSelect,
                                           @PathVariable String telInput){
        ReferringForm r = new ReferringForm();
        customerNameSelect += " tmp";
        String[] lCusName = customerNameSelect.split(" ");
        Customer customer = customerRepository.findByFullName(lCusName[0],lCusName[1]);//customerRepository.findByfristname(customerNameSelect);

        System.out.print(customer);
        dentistNameSelect += " tmp";
        String[] lDent = dentistNameSelect.split(" ");
        DentistData dentistData = dentistDataRepository.finnByfullName(lDent[0],lDent[1]);//dentistDataRepository.findByfirstname1(dentistNameSelect);

        System.out.print(dentistData);
        Type type = typeRepository.findBynameType( typeSelect);//typeRepository.findBytypes(typeSelect);
        System.out.print(type);

        BloodGroup bloodGroup = bloodGroupRepository.findByNameGroup(bloodGroupSelect);
        System.out.print(bloodGroup);

        r.setDate(dateInput);
        r.setTel(telInput);
        r.setType(type);
        r.setCustomer(customer);
        r.setDentistData(dentistData);
        r.setBloodGroup(bloodGroup);
        return referringFormRepository.save(r);
    }
    @DeleteMapping(path = "ReferringForm/{referringFormId}")
    void deleteReferringForm(@PathVariable Long referringFormId){
        referringFormRepository.deleteById(referringFormId);
    }
}

