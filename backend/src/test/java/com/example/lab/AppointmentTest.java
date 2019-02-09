package com.example.lab;

import com.example.lab.Entity.Appointment;
import com.example.lab.Entity.Customer;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Type;
import com.example.lab.Repository.AppointmentRepository;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.TypeRepository;
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

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private DentistDataRepository dentistDataRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private Validator validator;
    private Type type;
    private DentistData dentistData;
    private Customer customer;

    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByFullName("ทวี","ฐินใหม่");
        dentistData = dentistDataRepository.finnByfullName("ปัทมาภรณ์","ทองขวัญ");
        type = typeRepository.findBynameType("รักษารากฟัน");

    }

    @Test
    public void testPass() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("0955630020");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Success========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);

        }
    }

    //Test Tel  null
    @Test
    public void testTelNull() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel(null);

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Min Tel
    @Test
    public void testMinTel() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("09556300");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Min tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Max tel
    @Test
    public void testMaxTel() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("09556300205");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Max tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    //Test InvalidPattern Tel
    @Test
    public void testInvalidPatternTel() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("9556300209");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Invalid Pattern tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Date  null
    @Test
    public void testDateNull() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(null);
        ref.setTel("0955630020");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Date Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Customer  null
    @Test
    public void testCustomerNull() {
        Appointment ref = new Appointment();
        ref.setCustomer(null);
        ref.setDentistData(dentistData);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("0955630020");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Customer Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Dentist  null
    @Test
    public void testDentistNull() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(null);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("0955630020");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Dentist Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Type  null
    @Test
    public void testTypeNull() {
        Appointment ref = new Appointment();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        ref.setType(null);
        ref.setDate(new Date());
        ref.setTel("0955630020");

        try {
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================Test Date Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

}
