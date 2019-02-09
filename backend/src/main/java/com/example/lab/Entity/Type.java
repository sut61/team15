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
@Table(name = "Type")
public class Type {
    @Id
    @SequenceGenerator(name = "type_seq", sequenceName = "type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_seq")
    @Column(name = "TYPE_ID",unique = true, nullable = true)
    private @NonNull Long typeId;
    @NotNull
    private  String nameType;

    public String getName() {
        return nameType;
    }

    public void setName(String nameType) {
        this.nameType = nameType;
    }
}