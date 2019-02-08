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
@Table(name = "Medicaltificate")

public class Medicaltificate {
    @Id
    @SequenceGenerator(name = "medicaltificate_seq", sequenceName = "medicaltificate_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicaltificate_seq")
    @Column(name = "medicaltificateId" , unique = true, nullable = true)
    private @NonNull Long medicaltificateId;
    @NotNull
    @Size(min = 1 , max = 9 )
    @Pattern(regexp = "([ก-ู]|[เ-์])+")
    private String listorder;
    @NotNull
    @Size(min = 5 , max = 20 )
    private String comment;
    private Date dendate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentistDataId")
    private DentistData dentistData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treatmentrightId")
    private Treatmentrights treatmentrights;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private Type type;



    public String getListorder() {
        return listorder;
    }

    public void setListorder(String listorder) {
        this.listorder = listorder;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDendate() {
        return dendate;
    }

    public void setDendate(Date dendate) {
        this.dendate = dendate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DentistData getDentistData() {
        return dentistData;
    }

    public void setDentistData(DentistData dentistData) {
        this.dentistData = dentistData;
    }

    public Treatmentrights getTreatmentrights() {
        return treatmentrights;
    }

    public void setTreatmentrights(Treatmentrights treatmentrights) {
        this.treatmentrights = treatmentrights;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getMedicaltificateId() {
        return medicaltificateId;
    }

    public void setMedicaltificateId(Long medicaltificateId) {
        this.medicaltificateId = medicaltificateId;
    }
}
