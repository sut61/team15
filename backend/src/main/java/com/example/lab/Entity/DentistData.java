package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "DentistData")
public class DentistData {
    @Id
    @SequenceGenerator(name = "dentistData_seq", sequenceName = "dentistData_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentistData_seq")
    @Column(name = "dentistDataId" , unique = true, nullable = true)

    private @NonNull Long dentistDataId;

    @NotNull
    private  String firstname;
    @NotNull
    private  String lastname;
    @NotNull
    @Size(max=10,min=10)
    @Pattern(regexp = "^[1-9]{2}[0-9]{8}$")
    private  String number;


    @ManyToOne
    @JoinColumn(name = "genderId")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    public Long getDentistDataId() {
        return dentistDataId;
    }

    public void setDentistDataId(Long dentistDataId) {
        this.dentistDataId = dentistDataId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }


}