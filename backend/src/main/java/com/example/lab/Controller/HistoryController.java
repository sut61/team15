package com.example.lab.Controller;

import com.example.lab.Repository.CasehisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {
        @Autowired
            private CasehisRepository casehisRepository;
        @Autowired
            private CustomerRepository customerRepository;
        @Autowired
            private DentistDataRepository dentistDataRepository;
        @Autowired
            private TypeRepository typeRepository;
        @Autowired
            private HistoryRepository historyRepository;
        public HistoryController(HistoryRepository historyRepository,
                                 CasehisRepository casehisRepository,
                                 DentistDataRepository dentistDataRepository,
                                 CustomerRepository customerRepository,
                                 TypeRepository typeRepository){
            this.historyRepository = historyRepository;
            this.casehisRepository = casehisRepository;
            this.customerRepository = customerRepository;
            this.dentistDataRepository = dentistDataRepository;
            this.typeRepository = typeRepository;
        }

        //history
        @GetMapping(path = "/History", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<History> getHistory() {
            return historyRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/History/{HistoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public History getOneHistory(@PathVariable Long historyId){
            return historyRepository.findById(historyId).get();
        }

        //casehis
        @GetMapping(path = "/Casehis", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<Casehis> getCasehis() {
            return casehisRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/Casehis/{CasehisId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Casehis getOnecasehis(@PathVariable Long casehisId){
            return casehisRepository.findById(casehisId).get();
        }


        @PostMapping(path ="/History/{customerSelect}/{doctorSelect}/" +
            "{nameTypeSelect}/{casehisSelect}/{noteInput}")
        public History newHistory(@PathVariable String customerSelect , @PathVariable String doctorSelect,
                                  @PathVariable String nameTypeSelect, @PathVariable String casehisSelect,
                                  @PathVariable String noteInput
        ) {
            DateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            Date date = new Date();
        History his = new History();
        Customer customer = customerRepository.findByfirstname(customerSelect);
        System.out.print(customer);
        DentistData dentistData = dentistDataRepository.findByfirstname(doctorSelect);
        System.out.print(dentistData);
        Type type = typeRepository.findBynameType(nameTypeSelect);
        System.out.print(type);
        Casehis casehis = casehisRepository.findBycasehis(casehisSelect);
        System.out.print(casehis);

        his.setCustomer(customer);
        his.setDentistData(dentistData);
        his.setType(type);
        his.setCasehis(casehis);
        his.setNote(noteInput);
        his.setHisdate(new Date());
        return historyRepository.save(his);
    }
    @DeleteMapping(path ="history/{historyId}")
    void deleteHistory(@PathVariable Long historyId){
        historyRepository.deleteById(historyId);
    }
}

