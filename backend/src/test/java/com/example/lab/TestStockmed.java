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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestStockmed {
    @Autowired
    private FormmedRepository formmedRepository;
    @Autowired
    private DrugtypeRepository drugtypeRepository;
    @Autowired
    private ApackageRepository apackageRepository;
    @Autowired
    private StockmedRepository stockmedRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    private Formmed formmed;
    private Drugtype drugtype;
    private Apackage apackage;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        formmed = formmedRepository.findByname("ยาเม็ด");
        drugtype = drugtypeRepository.findByname("ยาอันตราย");
        apackage = apackageRepository.findByname("ขวด");
    }

    @Test
    public void testTestInsertSuccess() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            c.setDateexp(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    ///----------------------- Test null ----------------------- ///
    ///Name null
	@Test
	public void testTestNameNotNull() {
		Stockmed c = new Stockmed();
		c.setName(null);
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Name must not be null to be valid");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
            System.out.print("Test testTestNameNotNull >> ");
            System.out.println(e.getMessage()
                    + "----------------------------------------------------------------------------------------");
	}
	}
	///Idmedicine null
    @Test
    public void testTestIdmedicineNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine(null);
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("Test testTestIdmedicineNotNull >> ");
            System.out.println(e.getMessage()
                    + "----------------------------------------------------------------------------------------");
        }
    }
    ///Form null
    @Test
    public void testTestFormNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(null);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

        try {
            entityManager.persist(c);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("Test testTestFormNotNull >> ");
            System.out.println(e.getMessage()
                    + "----------------------------------------------------------------------------------------");
        }
    }
    ///Drugtype null
    @Test
    public void testTestDrugtypeNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(null);
        c.setApackage(apackage);

        try {
            entityManager.persist(c);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("Test testTestDrugtypeNotNull >> ");
            System.out.println(e.getMessage()
                    + "----------------------------------------------------------------------------------------");
        }
    }
    ///Apackage null
    @Test
    public void testTestApackageNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(null);

        try {
            entityManager.persist(c);
            entityManager.flush();

            //fail("Name must not be null to be valid");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("Test testTestApackageNotNull >> ");
            System.out.println(e.getMessage()
                    + "----------------------------------------------------------------------------------------");
        }
    }
    ///date null
    @Test
    public void testDateNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(null);
        c.setDateexp(new Date());
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    ///dateexp null
    @Test
    public void testDateexpNotNull() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M1234");
        c.setDate(new Date());
        c.setDateexp(null);
        c.setNumber(4);
        c.setFormmed(formmed);
        c.setDrugtype(drugtype);
        c.setApackage(apackage);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    ///----------------------- Test Size ----------------------- ///
    ///ใส่ค่าน้อยกว่า5
    @Test
    public void testMinSizeDetail() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M4");
        c.setDate(new Date());
        c.setDateexp(new Date());

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    ///ใส่ค่าเกิน5
    @Test
    public void testMaxSizeDetail() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M4gtrgrtgrtgtrgtrgtrgtrgtrgrtgrtgrtgtrgtrgrt");
        c.setDate(new Date());
        c.setDateexp(new Date());

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    ///----------------------- Test Pattern ----------------------- ///
    ///ขึ้นต้นด้วยตัว M ตามด้วยตัวเลข
    @Test
    public void testInvalidPatternDetail() {
        Stockmed c = new Stockmed();
        c.setName("anaerobe bacteria");
        c.setIdmedicine("M3456");
        c.setDate(new Date());
        c.setDateexp(new Date());

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
