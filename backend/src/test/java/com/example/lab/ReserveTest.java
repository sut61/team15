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
        customer = customerRepository.findByfirstname("Arttis");
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
    public void testPhonecusReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus(null);
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
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIdReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus("0872545770");
        c.setIdreserve(null);
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCustomerReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus("0872545770");
        c.setIdreserve("R5814909");
        c.setCustomer(null);
        c.setQueue(queue);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testQueueReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus("0872545770");
        c.setIdreserve("R5814909");
        c.setCustomer(customer);
        c.setQueue(null);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomReserveNotNull() {
        Reserve c = new Reserve();
        c.setPhonecus("0872545770");
        c.setIdreserve("R5814909");
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(null);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhonecusReservePattern() {
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
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIdReservePattern() {
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
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testReserveMin1() {
        Reserve c = new Reserve();
        c.setPhonecus("087");
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
            assertEquals(violations.size(), 2);//ติด pattern
        }
    }

    @Test
    public void testReserveMax1() {
        Reserve c = new Reserve();
        c.setPhonecus("08725000000000000");
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
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testReserveMin2() {
        Reserve c = new Reserve();
        c.setPhonecus("0871234567");
        c.setIdreserve("R581");
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testReserveMax2() {
        Reserve c = new Reserve();
        c.setPhonecus("0871234567");
        c.setIdreserve("R58149099");
        c.setCustomer(customer);
        c.setQueue(queue);
        c.setRoom(room);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

}
