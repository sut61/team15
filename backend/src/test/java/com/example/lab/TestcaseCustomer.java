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
import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestcaseCustomer {
    @Autowired
        private CustomerRepository customerRepository;
    @Autowired
        private GenderRepository genderRepository;
    @Autowired
        private ProvinceRepository provinceRepository;
    @Autowired
        private TypeRepository typeRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private Customer customer;
    private Gender gender;
    private Province province;
    private Type type;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        gender = genderRepository.findBygender("ชาย");
        province = provinceRepository.findByname("ชลบุรี");
        type = typeRepository.findBynameType("อุดฟัน");
    }
    @Test
    public void contextLoads()
    {
        System.out.println("Test Successful");
    }

    @Test
    public void testSuccess() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
        try {

            entityManager.persist(c);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    @Test
    public void testFirstnameNotNull() {
        Customer c = new Customer();
        c.setFirstname(null);
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
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
    public void testLastnameNotNull() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname(null);
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
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
    public void testIDcardNotNull() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard(null);
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
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
    public void testGenderNotNull() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(null);
        c.setProvince(province);
        c.setType(type);
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
    public void testProvinceNotNull() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(null);
        c.setType(type);
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
    public void testTypeNotNull() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(null);
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
    public void testLengthMin() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("130150025849");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //pattern ด้วย
            System.out.print("2.1  Test testTestLengthMin >> ");
            System.out.println(e.getMessage()
                    + "2.1------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    public void testLengthMax() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("130150025849600");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
        try {

            entityManager.persist(c);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestLengthMax >> ");
            System.out.println(e.getMessage()
                    + "2.1------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Test
    public void testPatternIDcard() {
        Customer c = new Customer();
        c.setFirstname("สมชาย");
        c.setLastname("สามารถ");
        c.setIdcard("1301500258496");
        c.setGender(gender);
        c.setProvince(province);
        c.setType(type);
        try {

            entityManager.persist(c);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
