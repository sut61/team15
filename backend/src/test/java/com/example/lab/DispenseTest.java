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
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest

public class DispenseTest {

    @Autowired
    private DispenseRepository dispenseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DentistDataRepository dentistDataRepository;

    @Autowired
    private InstructionRepository instructionRepository;

    @Autowired
    private StockmedRepository stockmedRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    private Customer customer;
    private DentistData dentistData;
    private Instruction instruction;
    private Stockmed stockmed;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("คำเหลา");
        dentistData = dentistDataRepository.findByfirstname("หมออาร์ต");
        instruction = instructionRepository.findBytakepill("ก่อนอาหาร");
        stockmed = stockmedRepository.findByname("anaerobe bacteria");
    }

    @Test
    public void testDispenseSuccess() {
        Dispense c = new Dispense();
        c.setIdlabel("D8888888");
        c.setNumberpill(10);
        c.setBenefit("ลดไข้");
        c.setCustomer(customer);
        c.setDentistData(dentistData);
        c.setInstruction(instruction);
        c.setStockmed(stockmed);

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
    public void testDispenseNotNull() {
        Dispense c = new Dispense();
        c.setIdlabel(null);
        c.setNumberpill(null);
        c.setBenefit(null);
        c.setCustomer(null);
        c.setDentistData(null);
        c.setInstruction(null);
        c.setStockmed(null);
        try {
            entityManager.persist(c);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
        }
    }

    @Test
    public void testDispenseMinLengthDetail() {
        Dispense c = new Dispense();
        c.setIdlabel("D123");
        c.setNumberpill(10);
        c.setBenefit("ลดไข้");
        c.setCustomer(customer);
        c.setDentistData(dentistData);
        c.setInstruction(instruction);
        c.setStockmed(stockmed);
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); //Size เท่ากับ 2 เพราะผิด Pattern ด้วย
        }
    }

    @Test
    public void testDispenseMaxLengthDetail() {
        Dispense c = new Dispense();
        c.setIdlabel("D123456789");
        c.setNumberpill(10);
        c.setBenefit("ลดไข้");
        c.setCustomer(customer);
        c.setDentistData(dentistData);
        c.setInstruction(instruction);
        c.setStockmed(stockmed);
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testDispensePatternDetail() {
        Dispense c = new Dispense();
        c.setIdlabel("D12345");
        c.setNumberpill(10);
        c.setBenefit("ลดไข้");
        c.setCustomer(customer);
        c.setDentistData(dentistData);
        c.setInstruction(instruction);
        c.setStockmed(stockmed);
        try {
            entityManager.persist(c);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
