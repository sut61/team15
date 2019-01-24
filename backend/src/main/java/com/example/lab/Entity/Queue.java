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
@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Queue")

public class Queue {
    @Id
    @SequenceGenerator(name="queue_seq",sequenceName="queue_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="queue_seq")
    @Column(name="Queue_ID",unique = true, nullable = true)
    private @NonNull long queueId;
    private String queueNumber;
    public Queue() {}

    public long getQueueId() {
        return queueId;
    }

    public void setQueueId(long queueId) {
        this.queueId = queueId;
    }

    public String getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }
}
