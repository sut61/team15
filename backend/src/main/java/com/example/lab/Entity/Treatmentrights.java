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
@Table(name = "Treatmentrights")
public class Treatmentrights {
    @Id
    @SequenceGenerator(name = "treatmentrights_seq", sequenceName = "treatmentrights_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatmentrights_seq")
    @Column(name = "treatmentrights_ID",unique = true, nullable = true)
    private @NonNull Long treatmentrightsId;
    @NonNull
    private String treatment;

    public Long getTreatmentrightsId() {
        return treatmentrightsId;
    }

    public void setTreatmentrightsId(Long treatmentrightsId) {
        this.treatmentrightsId = treatmentrightsId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
