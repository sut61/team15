package com.example.lab.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "History")
public class History {
    @Id
    @SequenceGenerator(name = "history_seq", sequenceName = "history_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq")
    @Column(name = "historyId" , unique = true, nullable = true)
    private @NonNull Long historyId;
    @NotNull
    private Date hisdate;

    @NotNull(message = " name Note must not be null to be valid")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^([ก-ู]|[เ-์])+")
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentisDataId")
    private DentistData dentistData;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "casehisId")
    private Casehis casehis;


    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) { this.historyId = historyId; }

    public Date getHisdate() {
        return hisdate;
    }

    public void setHisdate(Date hisdate) {
        this.hisdate = hisdate;
    }

    public String getNote() {
        return note;
    }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public DentistData getDentistData() { return dentistData; }

    public void setDentistData(DentistData dentistData) { this.dentistData = dentistData; }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public void setNote(String note) {
        this.note = note;
    }

    public Casehis getCasehis() { return casehis; }

    public void setCasehis(Casehis casehis) { this.casehis = casehis; }
}
