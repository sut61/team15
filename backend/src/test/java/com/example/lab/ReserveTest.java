package com.example.lab;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ReserveTest {
    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    private Customer customer;
    private Queue queue;
    private Room room;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("อนุพงษ์");
        queue = queueRepository.findByqueueNumber("C22");
        room = roomRepository.findByroomNumber("103");
    }

    @Test
    public void testReserveSuccess() {
        Reserve c = new Reserve();
        c.setPhonecus("0810733040");
        c.setIdreserve("R5814909");
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(room);

        try {
            entityManager.persist(c);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus(null);
        c.setIdreserve(null);
        c.setCustomer(null);
        c.setQueue(null);
        c.setRoom(null);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    @Test
    public void testReservePatternDetail() {
        Reserve c = new Reserve();
        c.setPhonecus("0872545770");
        c.setIdreserve("R5814909");
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //Size เท่ากับ 2 เพราะผิด Pattern ด้วย
        }
    }

}
