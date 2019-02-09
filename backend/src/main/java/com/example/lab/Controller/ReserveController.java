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
public class ReserveController {
    @Autowired
    private ReserveRepository reserveRepository;
    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    public ReserveController(ReserveRepository reserveRepository,
                             QueueRepository queueRepository,
                             CustomerRepository customerRepository,
                             RoomRepository roomRepository) {
        this.reserveRepository = reserveRepository;
        this.queueRepository = queueRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;

    }

    //Reserve
    @GetMapping(path = "/Reserve", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Reserve> getReserve() {
        return reserveRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Reserve/{reserveId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reserve getOneReserve(@PathVariable long reserveId){
        return reserveRepository.findById(reserveId).get();
    }

    //Queue
    @GetMapping(path = "/Queue", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Queue> getQueue() {
        return queueRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Queue/{QueueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Queue getOneQueue(@PathVariable long queueId){
        return queueRepository.findById(queueId).get();
    }


    //Room
    @GetMapping(path = "/Room", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Room> getRoom() {
        return roomRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Room/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getOneRoom(@PathVariable long roomId){
        return roomRepository.findById(roomId).get();
    }


    @PostMapping(path ="/reserve/{customerNameSelect}/{roomNumberSelect}/{queueNumberSelect}/{phonecusInput}/{idReserveInput}")
    public Reserve newReserve(@RequestBody Reserve reserve ,
                              @PathVariable String customerNameSelect,
                              @PathVariable String roomNumberSelect,
                              @PathVariable String queueNumberSelect,
                              @PathVariable String phonecusInput,
                              @PathVariable String idReserveInput) {
        Reserve r = new Reserve();

        Customer customer = customerRepository.findByfirstname(customerNameSelect);
        System.out.print(customer);

        Room room = roomRepository.findByroomNumber(roomNumberSelect);
        System.out.print(room);

        Queue queue = queueRepository.findByqueueNumber(queueNumberSelect);
        System.out.print(queue);

        r.setCustomer(customer);
        r.setRoom(room);
        r.setQueue(queue);
        r.setPhonecus(phonecusInput);
        r.setIdreserve(idReserveInput);
        return reserveRepository.save(r);

    }
    @DeleteMapping(path ="reserve/{reserveId}")
    void deleteReserve(@PathVariable Long reserveId){
        reserveRepository.deleteById(reserveId);
    }
}
