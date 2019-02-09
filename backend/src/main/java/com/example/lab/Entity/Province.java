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
@Table(name = "Province")
public class Province {
    @Id
    @SequenceGenerator(name = "province_seq",sequenceName = "province_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "province_seq")
    @Column(name = "PROVINCE_ID",unique = true, nullable = true)
    private @NonNull Long provinceId;
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
