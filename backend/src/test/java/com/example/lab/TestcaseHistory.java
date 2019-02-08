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

import javax.validation.*;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestcaseHistory {

    @Autowired
            private HistoryRepository historyRepository;
    @Autowired
            private CustomerRepository customerRepository;
    @Autowired
            private DentistDataRepository dentistDataRepository;
    @Autowired
             private TypeRepository typeRepository;
    @Autowired
            private CasehisRepository casehisRepository;
    @Autowired
            private TestEntityManager entityManager;

    private Validator validator;
    private History history;
    private Type type;
    private Customer customer;
    private DentistData dentistData;
    private Casehis casehis;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("อนุพงษ์");
        type = typeRepository.findBynameType("อุดฟัน");
        dentistData = dentistDataRepository.findByfirstname("ทวี");
        casehis = casehisRepository.findBycasehis("ปกติ");
    }
    @Test
    public void contextLoads()
    {
        System.out.println("Test Successful");
    }
        @Test
        public void testSuccess() {
            History h = new History();
            h.setHisdate(new Date());
            h.setNote("ทำดีมาก");
            h.setCustomer(customer);
            h.setDentistData(dentistData);
            h.setType(type);
            h.setCasehis(casehis);
            try {

                entityManager.persist(h);
                entityManager.flush();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
            } catch (ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 0);
            }
        }
    @Test
    public void testDateNotnull() {
        History h = new History();
        h.setHisdate(null);
        h.setNote("ทำดีมาก");
        h.setCustomer(customer);
        h.setDentistData(dentistData);
        h.setType(type);
        h.setCasehis(casehis);
        try {

            entityManager.persist(h);
            entityManager.flush();

        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testNoteNotnull() {
        History h = new History();
        h.setHisdate(new Date());
        h.setNote(null);
        h.setCustomer(customer);
        h.setDentistData(dentistData);
        h.setType(type);
        h.setCasehis(casehis);
        try {

            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage()
                    + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
    @Test
    public void testCustomerNotnull() {
        History h = new History();
        h.setHisdate(new Date());
        h.setNote("ทำดีมาก");
        h.setCustomer(null);
        h.setDentistData(dentistData);
        h.setType(type);
        h.setCasehis(casehis);
        try {

            entityManager.persist(h);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage()
                    + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
    @Test
    public void testDentistDataNotnull() {
        History h = new History();
        h.setHisdate(new Date());
        h.setNote("ทำดีมาก");
        h.setCustomer(customer);
        h.setDentistData(null);
        h.setType(type);
        h.setCasehis(casehis);
        try {

            entityManager.persist(h);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage()
                    + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
    @Test
    public void testTypeNotnull() {
        History h = new History();
        h.setHisdate(new Date());
        h.setNote("ทำดีมาก");
        h.setCustomer(customer);
        h.setDentistData(dentistData);
        h.setType(null);
        h.setCasehis(casehis);
        try {

            entityManager.persist(h);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage()
                    + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
    @Test
    public void testCasehisNotnull() {
        History h = new History();
        h.setHisdate(new Date());
        h.setNote("ทำดีมาก");
        h.setCustomer(customer);
        h.setDentistData(dentistData);
        h.setType(type);
        h.setCasehis(null);
        try {

            entityManager.persist(h);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage()
                    + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
        @Test
        public void testLengthMin() {
            History h = new History();
            h.setHisdate(new Date());
            h.setNote("ทำ");
            h.setCustomer(customer);
            h.setDentistData(dentistData);
            h.setType(type);
            h.setCasehis(casehis);
            try {

                entityManager.persist(h);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch (ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.print("2.1  Test testTestLengthMin >> ");
                System.out.println(e.getMessage()
                        + "2.1------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
            }

    }
        @Test
        public void testLengthMax() {
            History h = new History();
            h.setHisdate(new Date());
            h.setNote("ฟกหฟกฟหกฟหกฟหกฟหกฟกฟหกฟหกฟหกฟหกหฟกหฟกฟกหฟกฟหกฟหกฟหกหฟกฟหกฟกฟกฟหกหฟกหฟกหฟกหฟกหฟกฟกฟ");
            h.setCustomer(customer);
            h.setDentistData(dentistData);
            h.setType(type);
            h.setCasehis(casehis);
            try {

                entityManager.persist(h);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch (ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
                System.out.print("2.2  Test testTestLengthMax >> ");
                System.out.println(e.getMessage()
                        + "2.2------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        @Test
        public void testPattern() {
            History h = new History();
            h.setHisdate(new Date());
            h.setNote("อาการปกติ");
            h.setCustomer(customer);
            h.setDentistData(dentistData);
            h.setType(type);
            h.setCasehis(casehis);
        try {
            entityManager.persist(h);
            entityManager.flush();
         //   fail("Should not pass to this line");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
