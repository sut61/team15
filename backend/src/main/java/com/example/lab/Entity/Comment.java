package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Comment")
public class Comment {
    @Id
    @SequenceGenerator(name="comment_seq",sequenceName="comment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comment_seq")
    @Column(name="comment_ID",unique = true, nullable = true)
    private @NonNull Long comment_ID;
    @NotNull(message = " Comment must not be null to be valid")
    @Size(min = 5,max =20)
    @Pattern(regexp = "^([ก-ู]|[เ-์])+",message="Invalid Comment")
    private @NonNull String comment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "C_ID" ,insertable = true)
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DentistData.class)
    @JoinColumn(name = "Den_ID",insertable = true)
    @NotNull
    private DentistData denname;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Point.class)
    @JoinColumn(name = "point_ID",insertable = true)
    @NotNull
    private Point point;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DentistData getDenname() {
        return denname;
    }

    public void setDenname(DentistData denname) {
        this.denname = denname;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
