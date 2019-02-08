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
@Table(name = "Apackage")
public class Apackage {
    @Id
    @SequenceGenerator(name = "apackage_seq", sequenceName = "apackage_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apackage_seq")
    @Column(name = "APACKAGE_ID",unique = true, nullable = true)
    private @NonNull Long apackageId;
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


