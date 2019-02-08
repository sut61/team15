package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "BloodGroup")
public class BloodGroup {
    @Id
    @SequenceGenerator(name = "bloodGroup_seq", sequenceName = "bloodGroup_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloodGroup_seq")
    @Column(name = "bloodGroupId", unique = true, nullable = true)
    private @NonNull Long bloodGroupIds;
    @Column(name = "nameGroup")
    @NotNull
    @Size(min=1,max = 2)
    @Pattern(regexp = "[ABO]|(^A+[B])")
    private String nameGroup;



    @ManyToOne
    @JoinColumn(name = "referringFormId")
    private ReferringForm referringForm;

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
