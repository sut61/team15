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
@ToString
@EqualsAndHashCode
@Table(name = "Stockmed")
public class Stockmed {
    @Id
    @SequenceGenerator(name = "stockmed_seq", sequenceName = "stockmed_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stockmed_seq")
    @Column(name = "stockmedId" , unique = true, nullable = true)
    private @NonNull Long stockmedId;
    @NotNull
    private  String name;

    @NotNull
    @Size(min = 5, max = 5)
    @Pattern(regexp = "^M[0-9]+")
    private  String idmedicine;

    @NotNull
    private  Date date;
    @NotNull
    private  Date dateexp;
    @NotNull
    private  Integer number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugtypeId")
    private Drugtype drugtype;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formmedId")
    private Formmed formmed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apackageId")
    private Apackage apackage;

    public Stockmed( ) {
    }

    public Long getStockmedId() {
        return stockmedId;
    }

    public void setStockmedId(Long stockmedId) {
        this.stockmedId = stockmedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdmedicine() {
        return idmedicine;
    }

    public void setIdmedicine(String idmedicine) {
        this.idmedicine = idmedicine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateexp() {
        return dateexp;
    }

    public void setDateexp(Date dateexp) {
        this.dateexp = dateexp;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Drugtype getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(Drugtype drugtype) {
        this.drugtype = drugtype;
    }

    public Formmed getFormmed() {
        return formmed;
    }

    public void setFormmed(Formmed formmed) {
        this.formmed = formmed;
    }

    public Apackage getApackage() {
        return apackage;
    }

    public void setApackage(Apackage apackage) {
        this.apackage = apackage;
    }


}