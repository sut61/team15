package com.example.lab;


import com.example.lab.Entity.Comment;
import com.example.lab.Entity.Customer;
import com.example.lab.Entity.DentistData;
import com.example.lab.Entity.Point;
import com.example.lab.Repository.CommentRepository;
import com.example.lab.Repository.CustomerRepository;
import com.example.lab.Repository.DentistDataRepository;
import com.example.lab.Repository.PointRepository;
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

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Fail.fail;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TestComment {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private DentistDataRepository dentistDataRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    private Validator validator;

    private Customer customer;
    private DentistData dentistData;
    private Point point;
    
    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        customer = customerRepository.findByfirstname("Arttis");
        point = pointRepository.findBypoint(5);
        dentistData = dentistDataRepository.findByfirstname("หมออาร์ต");

    }
    @Test
    public void testSuccess() {
        Comment c = new Comment();
        c.setComment("รักนะครับคนดี");
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            System.out.println("TEST COMMENT ENTITY ALL VALID SUCCESS");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }//test Comment Notnull
    @Test
    public void testCommentNotnull() {
        Comment c = new Comment();
        c.setComment(null);
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }//test Comment min
    @Test
    public void testCommentMin() {
        Comment c = new Comment();
        c.setComment("1234");
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }//test Comment Max
    @Test
    public void testCommentMax() {
        Comment c = new Comment();
        c.setComment("วันหนึ่งเฉนเดินเข้าป่าฉันเจอนกตัวหนึ่งมันถามฉันว่าจะไปไหนฉันจึงบอกอยากไปให้ไกล");
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testCommentPattern() {
        Comment c = new Comment();
        c.setComment("รักนะครับคนดีของฉัน");
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    @Test
    public void testCustomerNotNull() {
        Comment c = new Comment();
        c.setComment("รักนะครับคนดีของฉัน");
        c.setCustomer(null);
        c.setPoint(point);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPointNotNull() {
        Comment c = new Comment();
        c.setComment("รักนะครับคนดีของฉัน");
        c.setCustomer(customer);
        c.setPoint(null);
        c.setDenname(dentistData);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testDentisNotNull() {
        Comment c = new Comment();
        c.setComment("รักนะครับคนดีของฉัน");
        c.setCustomer(customer);
        c.setPoint(point);
        c.setDenname(null);

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetCommentEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //**********************TEST CASE FOR POINT ENTITY***************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testPointSuccess() {
        Point p = new Point();
        p.setPoint(2);

        try {

            entityManager.persist(p);
            entityManager.flush();
            System.out.println("TEST POINT ENTITY ALL VALID SUCCESS");


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetPointEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    public void testPointNull() {
        Point p = new Point();
        p.setPoint(null);

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetPointtEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    public void testPointMin() {
        Point p = new Point();
        p.setPoint(0);

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetPointtEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    public void testPointMax() {
        Point p = new Point();
        p.setPoint(10);

        try {

            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetPointtEntitySuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
