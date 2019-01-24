package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter

@ToString
@EqualsAndHashCode
@Table(name = "User")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "userId" , unique = true, nullable = true)
    private @NonNull Long userId;
    private  String firstname;
    private  String lastname;
    private  Integer age;
    private  String phone;
    private  String idcard;
    private  String email;
    private  String password;

    @ManyToOne
    private Usertype type;

    @ManyToOne
    @JoinColumn(name = "genderId")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "provinceId")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "titleId")
    private Title title;

    public User(Usertype type) {
        this.type = type;
    }

    public User() {

    }
    public Usertype getType() {
        return type;
    }

    public void setType(Usertype type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}


