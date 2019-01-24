package com.example.lab.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Usertype {
    @Id
    @GeneratedValue
    private Long id;
    private String type;

    public Usertype(){}

    public Usertype(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
