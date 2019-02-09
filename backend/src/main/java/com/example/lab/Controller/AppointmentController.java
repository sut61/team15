package com.example.lab.Controller;

import com.example.lab.Entity.Customer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.lab.Entity.Appointment;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Type;
import com.example.lab.Repository.AppointmentRepository;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.TypeRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;

    public AppointmentController(AppointmentRepository appointmentRepository,
                                 TypeRepository typeRepository,
                                 CustomerRepository customerRepository,
                                 DentistDataRepository dentistDataRepository){
        this.appointmentRepository = appointmentRepository;
        this.typeRepository = typeRepository;
        this.customerRepository = customerRepository;
        this.dentistDataRepository = dentistDataRepository;
    }
    //appointment
    @GetMapping(path = "/Appointment",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Appointment> getAppointment(){
        return appointmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Appointment/{AppointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment getOneAppointment(@PathVariable Long appointmentId){
        return appointmentRepository.findById(appointmentId).get();
    }

    @GetMapping(path = "/CustomerDent", produces = MediaType.APPLICATION_JSON_VALUE)
    public String CustomerDent() throws JSONException {
        List<Customer> cAll = customerRepository.findAll();
        //JSONObject o = new JSONObject();
        JSONArray a = new JSONArray();
        for(int i  =0;i<cAll.size();i++)
        {
            JSONObject o = new JSONObject();
            o.put("ID",cAll.get(i).getCustomerId());
            o.put("FullName",cAll.get(i).getFirstname()+" "+cAll.get(i).getLastname());

            a.put(o);
        }

        return a.toString();
    }
    @GetMapping(path = "/DentFull", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DentFull() throws JSONException {
        List<DentistData> cAll = dentistDataRepository.findAll();

        JSONArray a = new JSONArray();
        for(int i  =0;i<cAll.size();i++)
        {
            try{JSONObject o = new JSONObject();
                o.put("ID",cAll.get(i).getDentistDataId());
                o.put("FullName",cAll.get(i).getFirstname()+" "+cAll.get(i).getLastname());
                a.put(o);
            }catch (JSONException e){
                throw e;
            }

        }

        return a.toString();
    }

    @GetMapping(path = "/Appointment/{dateInput}/{customerNameSelect}/{dentistNameSelect}/{typeSelect}/{telInput}")
    public Appointment newAppointment( @PathVariable Date dateInput,
                                      @PathVariable String customerNameSelect,
                                       @PathVariable String dentistNameSelect,
                                      @PathVariable String typeSelect,
                                       @PathVariable String telInput
    ){
        Appointment a = new Appointment();
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

        a.setDate(dateInput);
        a.setType(type);
        a.setCustomer(customer);
        a.setDentistData(dentistData);
        a.setTel(telInput);
        return appointmentRepository.save(a);
    }
    @DeleteMapping(path = "Appointment/{appointmentId}")
    void deleteAppointment(@PathVariable Long appointmentId){
        appointmentRepository.deleteById(appointmentId);
    }
}
