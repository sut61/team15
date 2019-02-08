package com.example.lab.Controller;

import com.example.lab.Entity.*;
import com.example.lab.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicaltificateController {
    @Autowired
    private MedicaltificateRepository medicaltificateRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TreatmentrightsRepository treatmentrightsRepository;
    @Autowired
    private TypeRepository typeRepository;

    public MedicaltificateController(DentistDataRepository dentistDataRepository,
                                     CustomerRepository customerRepository,
                                     TreatmentrightsRepository treatmentrightsRepository,
                                     TypeRepository typeRepository,
                                     MedicaltificateRepository medicaltificateRepository) {
        this.dentistDataRepository = dentistDataRepository;
        this.customerRepository = customerRepository;
        this.treatmentrightsRepository = treatmentrightsRepository;
        this.typeRepository = typeRepository;
        this.medicaltificateRepository = medicaltificateRepository;
    }

    //DentisData


    //treat
    @GetMapping(path = "/Treatmentrights", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Treatmentrights> getTreatmentrights() {
        return treatmentrightsRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Treatmentrights/{treatmentrightsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Treatmentrights getOneTreatmentrights(@PathVariable long treatmentrightsId) {
        return treatmentrightsRepository.findById(treatmentrightsId).get();
    }

    //type

    //medical
    @GetMapping(path = "/Medicaltificate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medicaltificate> getMedicaltificate() {
        return medicaltificateRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Medicaltificate/{medicaltificateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicaltificate getOneMedicaltificate(@PathVariable long medicaltificateId) {
        return medicaltificateRepository.findById(medicaltificateId).get();
    }

    @PostMapping(path = "/medicaltificate/{listorderInput}/{customerNameSelect}/{dentistDataSelect}/" +
            "{treatmentSelect}/{typeSelect}/{commentInput}")
    public Medicaltificate newMedicaltificate(@PathVariable String listorderInput,
                                              @PathVariable String customerNameSelect,
                                              @PathVariable String dentistDataSelect,
                                              @PathVariable String treatmentSelect,
                                              @PathVariable String typeSelect,
                                              @PathVariable String commentInput
    ) {
        DateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();

        Medicaltificate me = new Medicaltificate();
        Type type = typeRepository.findBynameType(typeSelect);
        System.out.print(type);

        Customer customer = customerRepository.findByfirstname(customerNameSelect);
        System.out.print(customer);

        Treatmentrights treatmentrights = treatmentrightsRepository.findBytreatment(treatmentSelect);
        System.out.print(treatmentrights);

        DentistData dentistData = dentistDataRepository.findByfirstname(dentistDataSelect);
        System.out.print(dentistData);

        me.setComment(commentInput);
        me.setListorder(listorderInput);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setDendate(new Date());


        return medicaltificateRepository.save(me);
    }

    @DeleteMapping(path = "medicaltificate/{medicaltificateId}")
    void deleteReserve(@PathVariable Long medicaltificateId) {
        medicaltificateRepository.deleteById(medicaltificateId);
    }
}
