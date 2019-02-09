package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Reserve")

public class Reserve {
    @Id
    @SequenceGenerator(name="reserve_seq",sequenceName="reserve_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reserve_seq")
    @Column(name="Reserve_ID",unique = true, nullable = true)
    private @NonNull long reserveId;

    @NotNull
    @Pattern(regexp = "^[0]{1}[689]{1}[0-9]{8}$")
    private  String phonecus;

    @NotNull
    @Pattern(regexp = "^[R]{1}[0-9]{7}$")
    private  String idreserve;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "queueId")
    private Queue queue;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Reserve() {}

    public long getReserveId() {
        return reserveId;
    }

    public void setReserveId(long reserveId) {
        this.reserveId = reserveId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPhonecus() {
        return phonecus;
    }

    public void setPhonecus(String phonecus) {
        this.phonecus = phonecus;
    }

    public String getIdreserve() {
        return idreserve;
    }

    public void setIdreserve(String idreserve) {
        this.idreserve = idreserve;
    }
}
