package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Formmed")
public class Formmed {
    @Id
    @SequenceGenerator(name = "formmed_seq",sequenceName = "formmed_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formmed_seq")
    @Column(name = "FORMMED_ID",unique = true, nullable = true)
    private @NonNull Long formmedId;
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
