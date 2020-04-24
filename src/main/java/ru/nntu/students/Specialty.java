package ru.nntu.students;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    private int id_specialty;
    private String spec_name;
    private int spec_cost;
    private int active_sign;

    public Specialty(){

    }
}
