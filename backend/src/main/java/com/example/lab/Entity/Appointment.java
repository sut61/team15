package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Appointment")

public class Appointment {
    @Id
    @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @Column(name = "APPOINTMENT_ID", unique = true, nullable = true)
    private @NonNull Long appointmetnId;
    @NotNull
    private Date date;
    @NotNull
    @Size(min=10,max = 10)
    @Pattern(regexp = "^0[689]+[0-9]+")
    private String tel;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dentistDataId")
    private DentistData dentistData;

    public Date getDate(){return date;}
    public void setDate(Date date){this.date = date;}

    public Type getType(){return type;}
    public void setType(Type type){this.type = type;}

    public Customer getCustomer(){return customer;}
    public void setCustomer(Customer customer){this.customer = customer;}

    public DentistData getDentistData(){return dentistData;}
    public void setDentistData(DentistData dentistData){this.dentistData = dentistData;}
}
