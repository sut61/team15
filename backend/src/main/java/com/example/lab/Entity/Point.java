package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Point")
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq", sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_seq")
    @Column(name = "POINT_ID", unique = true, nullable = true)
    private @NonNull
    Long P_id;
    @NotNull
    @Min(1)
    @Max(5)
    private
    Integer point;


    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

}
