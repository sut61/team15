package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Payment")
public class Payment {
    @Id
    @SequenceGenerator(name="payment_seq",sequenceName="payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_seq")
    @Column(name="Payment_ID",unique = true, nullable = true)
    private @NonNull Long pay_ID;

    @NotNull
    @Min(value = 1)
    @Max(value = 99999)
    @Positive
    private Integer payMent;
    @NotNull
    private  Date datePay;


    @NotNull(message = " Phone must not be null to be valid")
    @Size(min = 10,max = 10)
    @Pattern(regexp = "^08([0-9])+")
    private @NonNull String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "C_ID" ,insertable = true)
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "Type_ID",referencedColumnName="TYPE_ID",insertable = true)
    @NotNull
    private Type nameType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DentistData.class)
    @JoinColumn(name = "Den_ID",insertable = true)
    @NotNull
    private DentistData denname;

    public int getPayMent() {
        return payMent;
    }

    public void setPayMent(int payMent) {
        this.payMent = payMent;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Type getNameType() {
        return nameType;
    }

    public void setNameType(Type nameType) {
        this.nameType = nameType;
    }

    public DentistData getDenname() {
        return denname;
    }

    public void setDenname(DentistData denname) {
        this.denname = denname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
