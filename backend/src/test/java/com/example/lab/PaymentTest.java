package com.example.lab;

import com.example.lab.Entity.Customer;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Payment;
import com.example.lab.Entity.Type;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.PaymentRepository;
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
public class PaymentTest {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DentistDataRepository dentisdataRepository;
    @Autowired
    private TypeRepository typeRepository;

    private Validator validator;
    private Type type;
    private DentistData dentistData;
    private Customer customer;

    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("Arttis");
        dentistData = dentisdataRepository.findByfirstname("หมออาร์ต");
        type = typeRepository.findBynameType("ขูดหินปูน");
    }
    @Test
    public void testSuccess() {
        Payment p = new Payment();
        p.setPayMent(100);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }// TEST CASE PAYMENT ZERO AND MIN
    @Test
    public void testPaymentNotnullAndMin() {
        Payment p = new Payment();
        p.setPayMent(0);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);//เพราะ
        }
    }//TEST PAYMNT MAX
    @Test
    public void testPaymentMax() {
        Payment p = new Payment();
        p.setPayMent(10000000);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }// test date not null
    @Test
    public void testDateNotnull() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(null);

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }//  test Phone min and Phone pattern
    @Test
    public void testPhoeneMin() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("008567");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);// เป็น 2 เพราะผิด pettern ด้วย
        }
    }// test PhoneNumber Max
    @Test
    public void testPhoneMax() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("008567");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);// เป็น 2 เพราะผิด pettern ด้วย
        }
    }// test phone pattern
    @Test
    public void testPhonePattern() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    @Test
    public void testCustomerNotnull() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(null);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testDenNameNotnull() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("0885399036");
        p.setNameType(type);
        p.setCustomer(customer);
        p.setDenname(null);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    public void testTypeNameNotnull() {
        Payment p = new Payment();
        p.setPayMent(1000);
        p.setPhoneNumber("0885399036");
        p.setNameType(null);
        p.setCustomer(customer);
        p.setDenname(dentistData);
        p.setDatePay(new Date());

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
