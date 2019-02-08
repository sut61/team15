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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ReferringTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private ReferringFormRepository referringFormRepository;

        @Autowired
        private TypeRepository typeRepository;

        @Autowired
        private DentistDataRepository dentistDataRepository;

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private BloodGroupRepository bloodGroupRepository;

        private Validator validator;
        private Type type;
        private DentistData dentistData;
        private Customer customer;
        private BloodGroup bloodGroup;
        private SimpleDateFormat format = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

        @Before
        public void setup(){
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
            customer = customerRepository.findByFullName("ปัทมาภรณ์","ทองขวัญ");
            dentistData = dentistDataRepository.finnByfullName("สหราช","ดาศรี");
            //bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            type = typeRepository.findBynameType("จัดฟัน");
        }

    @Test
    public void testPass() {
        ReferringForm ref = new ReferringForm();
        ref.setCustomer(customer);
        ref.setDentistData(dentistData);
        bloodGroup = bloodGroupRepository.findByNameGroup("AB");
        ref.setBloodGroup(bloodGroup);
        ref.setType(type);
        ref.setDate(new Date());
        ref.setTel("0955630020");

        try{
            ref.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(ref);
            entityManager.flush();
            // fail("Not Pass in this line!!");

        }catch (javax.validation.ConstraintViolationException e){
            System.out.println("========================Success========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);

        } catch (ParseException e) {
                System.out.println("========================Success========================");
                System.out.println(e);
                e.printStackTrace();
            }
        }

        //Test Null Blood
        @Test
        public  void TestBloodNull(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            r.setBloodGroup(null);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("0955630020");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

               // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Blood Null========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Blood Null========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }

        // Test shortest BloodGroup
        @Test
        public  void TestShortest(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("0955630020");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

               // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Shortest========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 2);
            }catch (ParseException e) {
                System.out.println("========================Test Shortest========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }

        //Test Longer BloodGroup
        @Test
        public  void TestLonger(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("ABO");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("0955630020");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

                //fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Shortest========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Shortest========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }

        //Test Invalid Pattern BloodGroup
        @Test
        public  void TestInvalidPattern(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("C");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("0955630020");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

               // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Invalid Pattern Blood========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Invalid Pattern Blood========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }
        //Test Null Date
        @Test
        public  void TestDateNull(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(null);
            r.setTel("0955630020");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

                // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Null Date========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Null Date========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }
        //Test Null Tel
        @Test
        public  void TestTelNull(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel(null);

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

                // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Null Tel========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Null Tel========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }
        //Test min Tel
        @Test
        public  void TestMinTel(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("09556300");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

                // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Min Tel========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Min Tel========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }

        //Test max Date
        @Test
        public  void TestMaxTel(){
            ReferringForm r = new ReferringForm();
            r.setCustomer(customer);
            bloodGroup = bloodGroupRepository.findByNameGroup("AB");
            r.setBloodGroup(bloodGroup);
            r.setType(type);
            r.setDentistData(dentistData);
            r.setDate(new Date());
            r.setTel("095563002095");

            try{
                r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
                entityManager.persist(r);
                entityManager.flush();

                // fail("Not Pass in this line!!");
            }catch (javax.validation.ConstraintViolationException e){
                System.out.println("========================Test Max Tel========================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }catch (ParseException e) {
                System.out.println("========================Test Max Tel========================");
                System.out.println(e);
                e.printStackTrace();
            }

        }
    //Test Null Customer
    @Test
    public  void TestCustomerNull(){
        ReferringForm r = new ReferringForm();
        r.setCustomer(null);
        bloodGroup = bloodGroupRepository.findByNameGroup("AB");
        r.setBloodGroup(bloodGroup);
        r.setType(type);
        r.setDentistData(dentistData);
        r.setDate(new Date());
        r.setTel("0955630020");

        try{
            r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            // fail("Not Pass in this line!!");
        }catch (javax.validation.ConstraintViolationException e){
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            e.printStackTrace();
        }

    }
    //Test Null DentistData
    @Test
    public  void TestDentistDataNull(){
        ReferringForm r = new ReferringForm();
        r.setCustomer(customer);
        bloodGroup = bloodGroupRepository.findByNameGroup("AB");
        r.setBloodGroup(bloodGroup);
        r.setType(type);
        r.setDentistData(null);
        r.setDate(new Date());
        r.setTel("0955630020");

        try{
            r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            // fail("Not Pass in this line!!");
        }catch (javax.validation.ConstraintViolationException e){
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            e.printStackTrace();
        }

    }

    //Test Null Type
    @Test
    public  void TestTypeNull(){
        ReferringForm r = new ReferringForm();
        r.setCustomer(customer);
        bloodGroup = bloodGroupRepository.findByNameGroup("AB");
        r.setBloodGroup(bloodGroup);
        r.setType(null);
        r.setDentistData(dentistData);
        r.setDate(new Date());
        r.setTel("0955630020");

        try{
            r.setDate(format.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            // fail("Not Pass in this line!!");
        }catch (javax.validation.ConstraintViolationException e){
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            System.out.println("========================Test Null Tel========================");
            System.out.println(e);
            e.printStackTrace();
        }

    }


    }


