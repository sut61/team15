package com.example.lab;

import com.example.lab.Entity.*;

import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.GenderRepository;
import com.example.lab.Repository.HospitalRepository;
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
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest

public class DenTest {

    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private Type type;
    private Hospital hospital;
    private Gender gender;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        type = typeRepository.findBynameType("อุดฟัน");
        hospital = hospitalRepository.findByhospital("รัฐบาล");
        gender = genderRepository.findBygender("ชาย");

    }

    @Test
    public void contextLoads() {
        System.out.println("Test Successful");
    }

    @Test
    public void testSuccess() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1234567890");
        de.setHospital(hospital) ;
        de.setGender(gender);
        de.setType(type);
        try {
            entityManager.persist(de);
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
        DentistData de = new DentistData();
        de.setFirstname(null);
        de.setLastname(null);
        de.setNumber(null);
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(type);
        try {
            entityManager.persist(de);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.print("2.1  Test testTestNotNull >> ");
            System.out.println(e.getMessage() + "2-----------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void hospitalNotnull() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1309901371151");
        de.setHospital(null);
        de.setGender(gender);
        de.setType(type);
        try {
            entityManager.persist(de);
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
    public void genderNotnull() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1309901371151");
        de.setHospital(hospital);
        de.setGender(null);
        de.setType(type);
        try {
            entityManager.persist(de);
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
    public void typeNotnull() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1309901371151");
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(null);
        try {
            entityManager.persist(de);
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
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1309");
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(type);

        try {

            entityManager.persist(de);
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
    public void testLengthMax() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1309901371151");
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(type);
        try {

            entityManager.persist(de);
            entityManager.flush();
            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.2  Test testTestLengthMax >> ");
            System.out.println(e.getMessage()
                    + "2.2------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    @Test
    public void testPatternSuccess() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("1234567890");
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(type);
        try {

            entityManager.persist(de);
            entityManager.flush();
            //   fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }

    }
    @Test
    public void testPatternIdcard() {
        DentistData de = new DentistData();
        de.setFirstname("ธวรรณพร");
        de.setLastname("สามารถ");
        de.setNumber("asdasdasdasdasd");
        de.setHospital(hospital);
        de.setGender(gender);
        de.setType(type);
        try {

            entityManager.persist(de);
            entityManager.flush();
            //   fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }
}