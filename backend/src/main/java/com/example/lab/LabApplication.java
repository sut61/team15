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
						   BloodGroupRepository bloodGroupRepository
						  ) {
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
			//B5803569
				Hospital hos = new Hospital();
				hos.setName("รัฐบาล");
				Hospital hos1 = new Hospital();
				hos1.setName("เอกชน");

				hospitalRepository.save(hos);
				hospitalRepository.save(hos1);

				//B5814909
				Stream.of("101", "102", "103", "104").forEach(room -> {
					Room a = new Room();
					a.setRoomNumber(room);
					roomRepository.save(a);
				});
					Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").forEach(queue -> {
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
					customerRepository.save(c);

			});
			Stream.of("หมออาร์ต").forEach(dentisname->{
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






		};
	}
}

