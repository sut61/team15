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
@Table(name = "Title")
public class Title {
    @Id
    @SequenceGenerator(name = "title_seq", sequenceName = "title_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "title_seq")
    @Column(name = "TITLE_ID",unique = true, nullable = true)
    private @NonNull Long titleId;
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


