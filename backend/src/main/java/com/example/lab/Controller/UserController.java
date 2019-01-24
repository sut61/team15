package com.example.lab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.lab.Entity.*;
import com.example.lab.Repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsertypeRepository usertypeRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    public UserController(UserRepository userRepository, UsertypeRepository usertypeRepository,
                          TitleRepository titleRepository,
                          GenderRepository genderRepository,
                          ProvinceRepository provinceRepository) {
        this.userRepository = userRepository;
        this.usertypeRepository = usertypeRepository;
        this.titleRepository = titleRepository;
        this.genderRepository = genderRepository;
        this.provinceRepository = provinceRepository;
    }

    //User
    @GetMapping(path = "/User", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<User> getUser() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/User/{UserId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getOneUser(@PathVariable Long userId){ return userRepository.findById(userId).get();
    }
    //title
    @GetMapping(path = "/Title", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Title> getTitle() {
        return titleRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Title/{titleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Title getOneTitle(@PathVariable long titleId){
        return titleRepository.findById(titleId).get();
    }

    //gender
    @GetMapping(path = "/Gender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Gender> getGender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Gender/{genderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Gender getOneGender(@PathVariable long genderId){
        return genderRepository.findById(genderId).get();
    }
    //province
    @GetMapping(path = "/Province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> getProvince() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/province/{provinceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Province getOneProvince(@PathVariable long provinceId){
        return provinceRepository.findById(provinceId).get();
    }

    @PostMapping(path = "/email/{email}/password/{password}")
    public String login(@PathVariable String email, @PathVariable String password){
        User u1 = userRepository.findByemail(email);
        String passDB = u1.getPassword();
        String passFN = password;
        boolean isEqual = passDB.equals(passFN);
        System.out.println(isEqual);
        if(isEqual) {
            String success =  "{\"status\":\"200\",\"type\":\""+u1.getType()+"\"}";
            return success;
        } else {
            String fail =  "{\"status\":\"400\"}";
            return fail;
        }
    }

    @PostMapping(path ="/user/{titleNameSelect}/{firstnameInput}/{lastnameInput}/{ageInput}/{phoneInput}/{idcardInput}" +
            "/{genderNameSelect}/{provinceNameSelect}/{emailInput}/{passwordInput}")
    public User newUser(@RequestBody User user, @PathVariable String titleNameSelect,
                        @PathVariable String firstnameInput, @PathVariable String lastnameInput,
                        @PathVariable Integer ageInput, @PathVariable String phoneInput, @PathVariable String idcardInput,
                        @PathVariable String genderNameSelect, @PathVariable String provinceNameSelect,
                        @PathVariable String emailInput, @PathVariable String passwordInput
    ) {
        Usertype usertype = usertypeRepository.findBytype("employee");
        User em = new User();
        Gender gender = genderRepository.findBygender(genderNameSelect);
        System.out.print(gender);
        Province province = provinceRepository.findByname(provinceNameSelect);
        System.out.print(province);
        Title title = titleRepository.findByname(titleNameSelect);
        System.out.print(title);

        em.setTitle(title);
        em.setFirstname(firstnameInput);
        em.setLastname(lastnameInput);
        em.setAge(ageInput);
        em.setPhone(phoneInput);
        em.setIdcard(idcardInput);
        em.setGender(gender);
        em.setProvince(province);
        em.setEmail(emailInput);
        em.setPassword(passwordInput);
        em.setType(usertype);
        return userRepository.save(em);
    }
    @DeleteMapping(path ="user/{userId}")
    void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}

