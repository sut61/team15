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
public class DentistDataController {
    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private TypeRepository typeRepository;

    public DentistDataController(DentistDataRepository dentistDataRepository,
                                 HospitalRepository hospitalRepository,
                                 GenderRepository genderRepository,
                                 TypeRepository typeRepository) {
        this.dentistDataRepository = dentistDataRepository;
        this.hospitalRepository = hospitalRepository;
        this.genderRepository = genderRepository;
        this.typeRepository = typeRepository;
    }

    //DentisData
    @GetMapping(path = "/DentistData", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<DentistData> getDentistData() {
        return dentistDataRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/DentistData/{dentistDataId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DentistData getOnedentistData(@PathVariable Long dentistDataId){ return dentistDataRepository.findById(dentistDataId).get();
    }
    //hospital
    @GetMapping(path = "/Hospital", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Hospital> getHospital() {
        return hospitalRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Hospital/{hospitalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospital getOneHospital(@PathVariable long hospitalId){
        return hospitalRepository.findById(hospitalId).get();
    }



    @PostMapping(path ="/dentistData/{numberInput}/{firstnameInput}/{lastnameInput}/" +
                       "/{genderNameSelect}/{typeSelect}/{hospitalSelect}")

    public DentistData newDentistData(@RequestBody DentistData dentistData,
                                   @PathVariable String numberInput,
                                   @PathVariable String firstnameInput,
                                   @PathVariable String lastnameInput,
                                   @PathVariable String genderNameSelect,
                                   @PathVariable String typeSelect,
                                   @PathVariable String hospitalSelect

                                ) {
        DentistData c = new DentistData();
        Gender gender = genderRepository.findBygender(genderNameSelect);
        System.out.print(gender);
        Type type = typeRepository.findBynameType(typeSelect);
        System.out.print(type);
        Hospital hospital =hospitalRepository.findByhospital(hospitalSelect);
        System.out.print(hospital);


        c.setFirstname(firstnameInput);
        c.setLastname(lastnameInput);
        c.setNumber(numberInput);
        c.setGender(gender);
        c.setType(type);
        c.setHospital(hospital);
        return dentistDataRepository.save(c);
    }
    @DeleteMapping(path ="dentistData/{dentistDataId}")
    void deleteDentistData(@PathVariable Long dentistDataId){
       dentistDataRepository.deleteById(dentistDataId);
    }
}
