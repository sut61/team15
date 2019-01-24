package com.example.lab.Controller;


import com.example.lab.Entity.Customer;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Payment;
import com.example.lab.Entity.Type;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.PaymentRepository;
import com.example.lab.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DentistDataRepository dentisdatarepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentController(CustomerRepository customerRepository, DentistDataRepository dentisdatarepository, TypeRepository typeRepository, PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.dentisdatarepository = dentisdatarepository;
        this.typeRepository = typeRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/Payment")
    public Collection<Payment> payments() {
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/Payment/{fristNameSelect}/{doctorNameSelect}/{payMentInput}/{typeSelect}")
    public Payment recipt(@RequestBody Payment payment,
                          @PathVariable String fristNameSelect,
                          @PathVariable String doctorNameSelect,
                          @PathVariable String typeSelect,
                          @PathVariable int payMentInput
                          ){
        DateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        Payment p = new Payment();
        Customer customer1 = customerRepository.findByfirstname(fristNameSelect);
        System.out.println(fristNameSelect);
        DentistData dentistdata = dentisdatarepository.findByfirstname(doctorNameSelect);
        System.out.println(doctorNameSelect);
        Type t = typeRepository.findBynameType(typeSelect);
        System.out.println(typeSelect);





        p.setCustomer(customer1);
        p.setDenname(dentistdata);
        p.setNameType(t);
        p.setDatePay(new Date());
        p.setPayMent(payMentInput);

        return  paymentRepository.save(p);
    }

}
