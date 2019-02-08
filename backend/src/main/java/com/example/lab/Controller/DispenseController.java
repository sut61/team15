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
public class DispenseController {
    @Autowired
    private DispenseRepository dispenseRepository;
    @Autowired
    private StockmedRepository stockmedRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InstructionRepository instructionRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;

    public DispenseController(DispenseRepository dispenseRepository,
                              StockmedRepository stockmedRepository,
                              CustomerRepository customerRepository,
                              InstructionRepository instructionRepository,
                              DentistDataRepository dentistDataRepository) {
        this.dispenseRepository = dispenseRepository;
        this.stockmedRepository = stockmedRepository;
        this.customerRepository = customerRepository;
        this.instructionRepository = instructionRepository;
        this.dentistDataRepository = dentistDataRepository;

    }

    //Dispense
    @GetMapping(path = "/Dispense", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Dispense> getDispense() {
        return dispenseRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Dispense/{dispenseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dispense getOneDispense(@PathVariable long dispenseId){
        return dispenseRepository.findById(dispenseId).get();
    }





    //Instruction
    @GetMapping(path = "/Instruction", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Instruction> getInstruction() {
        return instructionRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Instruction/{instructionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Instruction getOneInstruction(@PathVariable long instructionId){
        return instructionRepository.findById(instructionId).get();
    }


    @PostMapping(path ="/dispense/{cusNameSelect}/{medNameSelect}/{idlabelInput}/{numberpillInput}/" +
            "/{takeNameSelect}/{benefitInput}/{docNameSelect}")
    public Dispense newDispense(@RequestBody Dispense dispense,
                               @PathVariable String cusNameSelect,
                                @PathVariable String docNameSelect,
                               @PathVariable String medNameSelect,
                               @PathVariable String takeNameSelect,
                               @PathVariable String idlabelInput,
                               @PathVariable Integer numberpillInput,
                               @PathVariable String benefitInput) {
        Dispense r = new Dispense();

        Customer customer = customerRepository.findByfirstname(cusNameSelect);
        System.out.print(customer);


        DentistData dentistData = dentistDataRepository.findByfirstname(docNameSelect);
        System.out.print(dentistData);


        Instruction instruction = instructionRepository.findBytakepill(takeNameSelect);
        System.out.print(instruction);

        Stockmed stockmed = stockmedRepository.findByname(medNameSelect);
        System.out.print(stockmed);

        r.setCustomer(customer);
        r.setDentistData(dentistData);
        r.setInstruction(instruction);
        r.setStockmed(stockmed);
        r.setNumberpill(numberpillInput);
        r.setBenefit(benefitInput);
        r.setIdlabel(idlabelInput);

        return dispenseRepository.save(r);

    }
    @DeleteMapping(path ="dispense/{dispenseId}")
    void deleteDispense(@PathVariable Long dispenseId){
        dispenseRepository.deleteById(dispenseId);
    }
}
