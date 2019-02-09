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
public class TestUser {
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    private Gender gender;
    private Province province;
    private Title title;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        gender = genderRepository.findBygender("หญิง");
        province = provinceRepository.findByname("นางสาว");
        title = titleRepository.findByname("ชลบุรี");
    }
    @Test
    public void testTestInsertSuccess() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);
        try {
            entityManager.persist(em);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);

        }
    }
    ///----------------------- Test null ----------------------- ///
    ///Firstname เป็น null
    @Test
    public void testTestFirstnameNotNull() {
        User em = new User();
        em.setFirstname(null);
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    /////Lastname เป็น null
    @Test
    public void testTestLastnameNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname(null);
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ////Age เป็น null
    @Test
    public void testTestAgeNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(null);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ////Phone เป็น null
    @Test
    public void testTestPhoneNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone(null);
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ////Idcard เป็น null
    @Test
    public void testTestIdcardNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard(null);
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ////Email เป็น null
    @Test
    public void testTestEmailNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail(null);
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ////Password เป็น null
    @Test
    public void testTestPasswordNotNull() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword(null);
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ///----------------------- Test Pattern ----------------------- ///
    ////Pattern Phone
    @Test
    public void testPhonePatternDetail() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ///Pattern Idcard
    @Test
    public void testIdcardPatternDetail() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ///Pattern Email
    @Test
    public void testEmailPatternDetail() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(21);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    ///----------------------- Test Size ----------------------- ///
    @Test
    public void testAgeSizeThenMax() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(100);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();
            //fail("fail");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
    @Test
    public void tesAgeSizelowerMin() {
        User em = new User();
        em.setFirstname("ธวรรณพร");
        em.setLastname("สามารถ");
        em.setAge(5);
        em.setPhone("0917239098");
        em.setIdcard("1200100657729");
        em.setEmail("ploythwp@gmail.com");
        em.setPassword("1234");
        em.setGender(gender);
        em.setProvince(province);
        em.setTitle(title);

        try {
            entityManager.persist(em);
            entityManager.flush();
            //fail("fail");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("\n\n================================ Print Error ================================\n\n");
            System.out.print(e.getConstraintViolations());
        }
    }
}
