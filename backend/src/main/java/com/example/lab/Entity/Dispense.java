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
@ToString
@EqualsAndHashCode
@Table(name = "Dispense")

public class Dispense {
    @Id
    @SequenceGenerator(name="dispense_seq",sequenceName="dispense_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="dispense_seq")
    @Column(name="Dispense_ID",unique = true, nullable = true)

    private @NonNull long dispenseId;

    @NotNull
    @Size(min = 5,max = 8)
    @Pattern(regexp = "^D[0-9]+")
    private String idlabel;

    @NotNull
    private Integer numberpill;
    @NotNull
    private String benefit;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructionId")
    private Instruction instruction;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stockmedId")
    private Stockmed stockmed;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentistDataId")
    private DentistData dentistData;

    public Dispense() {}

    public long getDispenseId() {
        return dispenseId;
    }

    public void setDispenseId(long dispenseId) {
        this.dispenseId = dispenseId;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Stockmed getStockmed() {
        return stockmed;
    }

    public void setStockmed(Stockmed stockmed) {
        this.stockmed = stockmed;
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

    public String getIdlabel() {
        return idlabel;
    }

    public void setIdlabel(String idlabel) {
        this.idlabel = idlabel;
    }

    public Integer getNumberpill() {
        return numberpill;
    }

    public void setNumberpill(Integer numberpill) {
        this.numberpill = numberpill;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }


}
