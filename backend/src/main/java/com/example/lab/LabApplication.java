package com.example.lab;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import java.util.Date;
import java.util.stream.Stream;
@SpringBootApplication
public class LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}
	@Bean
	ApplicationRunner init(UserRepository userRepository, UsertypeRepository usertypeRepository, GenderRepository genderRepository,
						   ProvinceRepository provinceRepository,TitleRepository titleRepository, TypeRepository typeRepository,
						   CustomerRepository customerRepository,DentistDataRepository dentistDataRepository, HospitalRepository hospitalRepository,
						   ReserveRepository reserveRepository,RoomRepository roomRepository,QueueRepository queueRepository,
						   AppointmentRepository appointmentRepository,PointRepository pointRepository,ReferringFormRepository referringFormRepository,
						   BloodGroupRepository bloodGroupRepository,StockmedRepository stockmedRepository, DrugtypeRepository drugtypeRepository,
						   FormmedRepository formmedRepository, ApackageRepository apackageRepository,DispenseRepository dispenseRepository,
						   InstructionRepository instructionRepository, CasehisRepository casehisRepository, HistoryRepository historyRepository,MedicaltificateRepository medicaltificateRepository,
						   TreatmentrightsRepository treatmentrightsRepository) {
		return args -> {
			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"
					,"ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
					,"นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา"
					,"พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน"
					,"ยะลา","ยโสธร","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล"
					,"สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย"
					,"หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(provinces -> {
				Province p = new Province();
				p.setName(provinces);
				provinceRepository.save(p);
			});
			//B5807819
			Usertype usertype = new Usertype();
			usertype.setType("admin");
			usertypeRepository.save(usertype);

			Usertype usertype2 = new Usertype();
			usertype2.setType("employee");
			usertypeRepository.save(usertype2);

			Gender g = new Gender();
			g.setGender("ชาย");
			Gender g2 = new Gender();
			g2.setGender("หญิง");
			genderRepository.save(g);
			genderRepository.save(g2);

			Title t = new Title();
			t.setName("นาย");
			Title t1 = new Title();
			t1.setName("นาง");
			Title t2 = new Title();
			t2.setName("นางสาว");
			titleRepository.save(t);
			titleRepository.save(t1);
			titleRepository.save(t2);

			User em = new User();
			em.setFirstname("ธวรรณพร");
			em.setLastname("สามารถ");
			em.setAge(21);
			em.setPhone("0917239098");
			em.setIdcard("1200100657729");
			em.setEmail("ploythwp@gmail.com");
			em.setPassword("1234");
			Usertype ut = usertypeRepository.findBytype("admin");
			em.setType(ut);


			Gender gender = genderRepository.findBygender("ชาย");
			Gender gender2 = genderRepository.findBygender("หญิง");
			em.setGender(gender);
			em.setGender(gender2);

			Title title = titleRepository.findByname("นาย");
			Title title1 = titleRepository.findByname("นาง");
			Title title2 = titleRepository.findByname("นางสาว");
			em.setTitle(title);
			em.setTitle(title1);
			em.setTitle(title2);

			Province province = provinceRepository.findByname("ชลบุรี");
			em.setProvince(province);

			userRepository.save(em);
			userRepository.findAll().forEach(System.out::println);

			//B5815074
			Stream.of("ถอนฟัน","อุดฟัน","ขูดหินปูน","จัดฟัน").forEach(nametype -> {
				Type typecus = new Type();
				typecus.setName(nametype);
				typeRepository.save(typecus);
			});

			Stream.of("ปกติ","พิเศษ").forEach(cases -> {
				Casehis ca = new Casehis();
				ca.setCasehis(cases);
				casehisRepository.save(ca);
			});
			//B5803569
				Hospital hos = new Hospital();
				hos.setName("รัฐบาล");
				Hospital hos1 = new Hospital();
				hos1.setName("เอกชน");

				hospitalRepository.save(hos);
				hospitalRepository.save(hos1);


				Stream.of("ไม่มี","สิทธฺ์30บาท","ประกันสังคม","อื่นๆ").forEach(treatment -> {
					Treatmentrights tr = new Treatmentrights();
					tr.setTreatment(treatment);
					treatmentrightsRepository.save(tr);
				});

				//B5814909
				Stream.of("101", "102", "103", "104").forEach(room -> {
					Room a = new Room();
					a.setRoomNumber(room);
					roomRepository.save(a);
				});
					Stream.of("C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10",
							"C11", "C12", "C13", "C14", "C15", "C16", "C17", "C18", "C19", "C20",
							"C21", "C22", "C23", "C24", "C25", "C26", "C27", "C28", "C29", "C30").forEach(queue -> {
						Queue q = new Queue();
						q.setQueueNumber(queue);
						queueRepository.save(q);
				});



			//B5804566  data Point
			Stream.of(1,2,3,4,5).forEach(point->{
				Point p = new Point();
				p.setPoint(point);
				pointRepository.save(p);
			});
			Stream.of("Arttis").forEach(username->{
					Customer c = new Customer();
					c.setFirstname(username);
					c.setLastname("khamamprai");
					c.setIdcard("1234567893256");
					customerRepository.save(c);

			});
			Stream.of("หมออาร์ต","ทวี","ta").forEach(dentisname->{


					DentistData d = new DentistData();
					d.setFirstname(dentisname);
					d.setLastname("สุดหล่อ");
					dentistDataRepository.save(d);

			});

			//Refering
			Stream.of("A","B","O","AB").forEach(nameGroup ->{
				BloodGroup b = new BloodGroup();
				b.setNameGroup(nameGroup);
				bloodGroupRepository.save(b);
			});

			//B5807819#2
			Formmed f = new Formmed();
			f.setName("ยาเม็ด");
			Formmed f1 = new Formmed();
			f1.setName("ยาน้ำ");
			Formmed f2 = new Formmed();
			f2.setName("ยาฉีด");
			Formmed f3 = new Formmed();
			f3.setName("อื่นๆ");
			formmedRepository.save(f);
			formmedRepository.save(f1);
			formmedRepository.save(f2);
			formmedRepository.save(f3);

			Drugtype d = new Drugtype();
			d.setName("ยาอันตราย");
			Drugtype d2 = new Drugtype();
			d2.setName("ยาปฏิชีวนะ");
			Drugtype d3 = new Drugtype();
			d3.setName("ยาทั่วไป");
			drugtypeRepository.save(d);
			drugtypeRepository.save(d2);
			drugtypeRepository.save(d3);

			Apackage ap = new Apackage();
			ap.setName("ขวด");
			Apackage ap1 = new Apackage();
			ap1.setName("แผง");
			Apackage ap2 = new Apackage();
			ap2.setName("แพ็ค");
			apackageRepository.save(ap);
			apackageRepository.save(ap1);
			apackageRepository.save(ap2);

			Stockmed c = new Stockmed();
			c.setName("anaerobe bacteria");
			c.setIdmedicine("M1234");
			c.setDate(new Date());
			c.setDateexp(new Date());
			c.setNumber(4);

			Drugtype drugtype = drugtypeRepository.findByname("ยาอันตราย");
			Drugtype drugtype2 = drugtypeRepository.findByname("ยาปฏิชีวนะ");
			Drugtype drugtype3 = drugtypeRepository.findByname("ยาทั่วไป");
			c.setDrugtype(drugtype);
			c.setDrugtype(drugtype2);
			c.setDrugtype(drugtype3);

			Apackage apackage = apackageRepository.findByname("ขวด");
			Apackage apackage1 = apackageRepository.findByname("แผง");
			Apackage apackage2 = apackageRepository.findByname("แพ็ค");
			c.setApackage(apackage);
			c.setApackage(apackage1);
			c.setApackage(apackage2);

			Formmed formmed = formmedRepository.findByname("ยาเม็ด");
			Formmed formmed1 = formmedRepository.findByname("ยาน้ำ");
			Formmed formmed2 = formmedRepository.findByname("ยาฉีด");
			Formmed formmed3 = formmedRepository.findByname("อื่นๆ");
			c.setFormmed(formmed);
			c.setFormmed(formmed1);
			c.setFormmed(formmed2);
			c.setFormmed(formmed3);

			stockmedRepository.save(c);
			stockmedRepository.findAll().forEach(System.out::println);


			//B5814909 #Sprint2

			Stream.of("ก่อนอาหาร", "หลังอาหาร").forEach(instruction -> {
				Instruction a = new Instruction();
				a.setTakepill(instruction);
				instructionRepository.save(a);
			});

			Stream.of("คำเหลา").forEach(customer -> {
				Customer m = new Customer();
				m.setFirstname(customer);
				m.setLastname("สัส");
				m.setIdcard("1234567891234");
				customerRepository.save(m);
			});

			Dispense r = new Dispense();

			Customer customer = customerRepository.findByfirstname("คำเหลา");
			r.setCustomer(customer);

			DentistData dentistData = dentistDataRepository.findByfirstname("หมออาร์ต");
			r.setDentistData(dentistData);


			Instruction instruction = instructionRepository.findBytakepill("ก่อนอาหาร");
			r.setInstruction(instruction);


			Stockmed stockmed = stockmedRepository.findByname("anaerobe bacteria");
			r.setStockmed(stockmed);

			r.setIdlabel("D12345");
			r.setBenefit("ลดไข้");
			r.setNumberpill(10);

			dispenseRepository.save(r);

			//B5815074
			History h = new History();
			h.setNote("อาการปกติ");

			h.setHisdate(new Date());

			Customer customer1 = customerRepository.findByfirstname("อนุพงษ์");
			h.setCustomer(customer1);

			DentistData dentistData1 = dentistDataRepository.findByfirstname("ทวี");
			h.setDentistData(dentistData1);

			Casehis casehis = casehisRepository.findBycasehis("ปกติ");
			h.setCasehis(casehis);

			Type type = typeRepository.findBynameType("อุดฟัน");
			h.setType(type);

			historyRepository.save(h);
			historyRepository.findAll().forEach(System.out::println);

			//b5803569
			Medicaltificate me = new Medicaltificate();
			me.setListorder("กก");
			me.setComment("บริการดีมาก");

			DentistData dentistData2 = dentistDataRepository.findByfirstname("ta");
			me.setDentistData(dentistData2);

			Customer customer2 = customerRepository.findByfirstname("new");
			me.setCustomer(customer2);
			me.setDendate(new Date());
			Type type2 = typeRepository.findBynameType("อุดฟัน");
			me.setType(type2);

			Treatmentrights treatmentrights = treatmentrightsRepository.findBytreatment("ไม่มี");
			me.setTreatmentrights(treatmentrights);

			medicaltificateRepository.save(me);
			medicaltificateRepository.findAll().forEach(System.out::println);



		};
	}
}

