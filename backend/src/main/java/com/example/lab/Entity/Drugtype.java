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
@Table(name = "Drugtype")
public class Drugtype {
    @Id
    @SequenceGenerator(name = "drugtype_seq",sequenceName = "drugtype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "drugtype_seq")
    @Column(name = "DRUGTYPE_ID" ,unique = true, nullable = true)
    private @NonNull Long drugtypeId;
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}