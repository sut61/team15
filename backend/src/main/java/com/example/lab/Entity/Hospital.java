package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Hospital")
public class Hospital {
    @Id
    @SequenceGenerator(name = "hospital_seq", sequenceName = "hospital_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_seq")
    @Column(name = "hospital_ID",unique = true, nullable = true)
    private @NonNull Long hospitalId;

    private  String hospital;

    public String getName() {
        return hospital;
    }

    public void setName(String hospital) {
        this.hospital = hospital;
    }
}


