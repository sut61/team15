package com.example.lab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockmedController {
    @Autowired
    private StockmedRepository stockmedRepository;
    @Autowired
    private ApackageRepository apackageRepository;
    @Autowired
    private DrugtypeRepository drugtypeRepository;
    @Autowired
    private FormmedRepository formmedRepository;

    public StockmedController(StockmedRepository stockmedRepository,
                              ApackageRepository apackageRepository,
                              DrugtypeRepository drugtypeRepository,
                              FormmedRepository formmedRepository) {
        this.stockmedRepository = stockmedRepository;
        this.apackageRepository = apackageRepository;
        this.drugtypeRepository = drugtypeRepository;
        this.formmedRepository = formmedRepository;
    }

    //stockmed
    @GetMapping(path = "/Stockmed", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Stockmed> getStockmed() {
        return stockmedRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Stockmed/{StockmedId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stockmed getOneStockmed(@PathVariable Long stockmedId){ return stockmedRepository.findById(stockmedId).get();
    }
    //apackage
    @GetMapping(path = "/Apackage", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Apackage> getApackage() {
        return apackageRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Apackage/{apackageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Apackage getOneApackage(@PathVariable long apackageId){
        return apackageRepository.findById(apackageId).get();
    }

    //drugtype
    @GetMapping(path = "/Drugtype", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Drugtype> getDrugtype() {
        return drugtypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Drugtype/{drugtypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Drugtype getOneDrugtype(@PathVariable long drugtypeId){
        return drugtypeRepository.findById(drugtypeId).get();
    }
    //formmed
    @GetMapping(path = "/Formmed", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Formmed> getFormmed() {
        return formmedRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Formmed/{formmedId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Formmed getOneFormmed(@PathVariable long formmedId){
        return formmedRepository.findById(formmedId).get();
    }

    @PostMapping(path ="/stockmed/{nameInput}/{idmedicineInput}/{dateInput}/{dateexpInput}" +
                       "/{drugtypeNameSelect}/{formmedNameSelect}/{numberInput}/{apackageNameSelect}")
    public Stockmed newStockmed (@RequestBody Stockmed stockmed, @PathVariable Integer numberInput,
                                 @PathVariable String nameInput, @PathVariable String idmedicineInput,
                                 @PathVariable Date dateInput, @PathVariable Date dateexpInput,
                                 @PathVariable String drugtypeNameSelect, @PathVariable String formmedNameSelect,
                                 @PathVariable String apackageNameSelect
                                ) {
        Stockmed c = new Stockmed();
        Drugtype drugtype = drugtypeRepository.findByname(drugtypeNameSelect);
        System.out.print(drugtype);
        Formmed formmed = formmedRepository.findByname(formmedNameSelect);
        System.out.print(formmed);
        Apackage apackage = apackageRepository.findByname(apackageNameSelect);
        System.out.print(apackage);

        c.setName(nameInput);
        c.setIdmedicine(idmedicineInput);
        c.setDate(dateInput);
        c.setDateexp(dateexpInput);
        c.setDrugtype(drugtype);
        c.setFormmed(formmed);
        c.setNumber(numberInput);
        c.setApackage(apackage);
        return stockmedRepository.save(c);
    }
    @DeleteMapping(path ="stockmed/{stockmedId}")
    void deleteStockmed(@PathVariable Long stockmedId){
       stockmedRepository.deleteById(stockmedId);
    }
}
