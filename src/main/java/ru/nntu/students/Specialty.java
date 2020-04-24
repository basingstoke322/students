package ru.nntu.students;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_specialty;
    private String spec_name;
    private int spec_cost;
    private int active_sign;

    protected Specialty(){}

    public Specialty(String spec_name, int spec_cost){
        this.spec_name = spec_name;
        this.spec_cost = spec_cost;
        this.active_sign = 1;
    }

    public int getId_specialty(){
        return id_specialty;
    }
    public int getSpec_cost(){
        return spec_cost;
    }
    public String getSpec_name(){
        return spec_name;
    }
    public int getActive_sign(){
        return active_sign;
    }
}
