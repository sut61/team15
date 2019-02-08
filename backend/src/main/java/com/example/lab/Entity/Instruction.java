package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Instruction")

public class Instruction {
    @Id
    @SequenceGenerator(name="instruction_seq",sequenceName="instruction_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="instruction_seq")
    @Column(name="Instruction_ID",unique = true, nullable = true)
    private @NonNull long instructionId;
    private String takepill;
    public Instruction() {}

    public long getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(long instructionId) {
        this.instructionId = instructionId;
    }

    public String getTakepill() {
        return takepill;
    }

    public void setTakepill(String takepill) {
        this.takepill = takepill;
    }
}
