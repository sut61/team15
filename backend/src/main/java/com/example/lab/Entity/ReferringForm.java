package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ReferringForm")
public class ReferringForm {
    @Id
    @SequenceGenerator(name = "referringForm_seq", sequenceName = "referringForm_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referringForm_seq")
    @Column(name = "REFERRINGFORM_ID", unique = true, nullable = true)
    private @NotNull Long referringFormId;
    @NotNull (message = " Comment must not be null to be valid")
    @Size(min=10,max = 10)
    @Pattern(regexp = "^0[689]+[0-9]+")
    private String tel;

    @NotNull
    private Date date;



    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = DentistData.class)
    @JoinColumn(name = "dentistDataId")
    private DentistData dentistData;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = BloodGroup.class)
    @JoinColumn(name = "bloodGroupId")
    private BloodGroup bloodGroup;

    public Date getDate(){return date;}
    public void setDate(Date date){this.date = date;}


    public Type getType(){return type;}
    public void setType(Type type){this.type = type;}

    public Customer getCustomer(){return customer;}
    public void setCustomer(Customer customer){this.customer = customer;}

    public DentistData getDentistData(){return dentistData;}
    public void setDentistData(DentistData dentistData){this.dentistData = dentistData;}
}
