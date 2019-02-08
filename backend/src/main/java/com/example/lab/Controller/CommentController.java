package com.example.lab.Controller;


import com.example.lab.Entity.Comment;
import com.example.lab.Entity.Customer;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Point;
import com.example.lab.Repository.CommentRepository;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.PointRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {
    private CustomerRepository customerRepository;
    private DentistDataRepository dentistDataRepository;
    private PointRepository pointRepository;
    private CommentRepository commentRepository;

    public CommentController(CustomerRepository customerRepository, DentistDataRepository dentistDataRepository, PointRepository pointRepository, CommentRepository commentRepository) {
        this.customerRepository = customerRepository;
        this.dentistDataRepository = dentistDataRepository;
        this.pointRepository = pointRepository;
        this.commentRepository = commentRepository;
    }
    @GetMapping("/Point")
    public Collection<Point> points(){
        return pointRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Comment")
    public Collection<Comment> comments(){
        return commentRepository.findAll().stream().collect(Collectors.toList());
    }@PostMapping("/Comment/{customerNameSelect}/{docterNameSelect}/{contentInput}/{PointSelect}")
    public Comment comment(
            @PathVariable String docterNameSelect,
            @PathVariable String customerNameSelect,
            @PathVariable String contentInput,
            @PathVariable int PointSelect){
        Comment c = new Comment();
        Customer cus = customerRepository.findByfirstname(customerNameSelect);
        System.out.println(customerNameSelect);
        DentistData d = dentistDataRepository.findByfirstname(docterNameSelect);
        System.out.println(docterNameSelect);
        Point p = pointRepository.findBypoint(PointSelect);
        System.out.println(PointSelect);


        c.setComment(contentInput);
        c.setCustomer(cus);
        c.setDenname(d);
        c.setPoint(p);

        return commentRepository.save(c);
    }
}