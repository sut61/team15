package com.example.lab;


import com.example.lab.Entity.*;
import com.example.lab.Repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MedTest {
    @Autowired
    private MedicaltificateRepository medicaltificateRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TreatmentrightsRepository treatmentrightsRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private Customer customer;
    private DentistData dentistData;
    private Type type;
    private Treatmentrights treatmentrights;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("Arttis");
        type = typeRepository.findBynameType("อุดฟัน");
        dentistData = dentistDataRepository.findByfirstname("หมออาร์ต");
        treatmentrights = treatmentrightsRepository.findBytreatment("ไม่มี");

    }

    @Test
    public void contextLoads() {
        System.out.println("Test Successful");
    }

    @Test
    public void testSuccess() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        try {

            entityManager.persist(me);
            entityManager.flush();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder(null);
        me.setComment(null);
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void denDateNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(null);
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void treatmentrightsNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(null);
        me.setType(type);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void TypeNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(treatmentrights);
        me.setType(null);
        me.setCustomer(customer);
        me.setDentistData(dentistData);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void CustomerNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setCustomer(null);
        me.setDentistData(dentistData);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void DentistDataNotnull() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดี");
        me.setTreatmentrights(treatmentrights);
        me.setType(type);
        me.setCustomer(customer);
        me.setDentistData(null);
        try {
            entityManager.persist(me);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }



    @Test
    public void testLengthMin() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setComment("กก");
        me.setListorder("ห");

        try {

            entityManager.persist(me);
            entityManager.flush();
           // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestLengthMin >> ");
            System.out.println(e.getMessage()
                    + "2.1------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
        @Test
        public void testLengthMax () {
            Medicaltificate me = new Medicaltificate();
            me.setDendate(new Date());
            me.setListorder("กก");
            me.setComment("กกกกกกกกกกกกกก");
            try {

                entityManager.persist(me);
                entityManager.flush();
               // fail("Should not pass to this line");
            } catch (javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 2);
                System.out.print("2.2  Test testTestLengthMax >> ");
                System.out.println(e.getMessage()
                        + "2.2------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    @Test
    public void testPattern() {
        Medicaltificate me = new Medicaltificate();
        me.setDendate(new Date());
        me.setListorder("กก");
        me.setComment("บริการดีมาก");
        try {

            entityManager.persist(me);
            entityManager.flush();
         //   fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

}


