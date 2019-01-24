package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "queueId")
    private Queue queue;
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
}
