package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Casehis")
public class Casehis {
    @Id
    @SequenceGenerator(name = "casehis_seq", sequenceName = "casehis_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casehis_seq")
    @Column(name = "casehisId" , unique = true, nullable = true)
    private @NonNull Long casehisId;
    @NotNull
    private  String casehis;

    public Long getCasehisId() {
        return casehisId;
    }

    public void setCasehisId(Long casehisId) {
        this.casehisId = casehisId;
    }

    public String getCasehis() {
        return casehis;
    }

    public void setCasehis(String casehis) {
        this.casehis = casehis;
    }
}
