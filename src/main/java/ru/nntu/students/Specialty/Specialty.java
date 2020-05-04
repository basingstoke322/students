package ru.nntu.students.Specialty;

import javax.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpecialty;
    private String specName;
    private int specCost;
    public int activeSign;

    protected Specialty() {
    }

    public Specialty(String specName, int specCost) {
        this.specName = specName;
        this.specCost = specCost;
        this.activeSign = 1;
    }

    public int getIdSpecialty() {
        return idSpecialty;
    }

    public int getSpecCost() {
        return specCost;
    }

    public String getSpecName() {
        return specName;
    }

    public int getActiveSign() {
        return activeSign;
    }
    public void setSpecCost(int spec_cost) {
        this.specCost = spec_cost;
    }

    public void setSpecName(String spec_name) {
        this.specName = spec_name;
    }

    public void setActiveSign(int active_sign) {
        this.activeSign = active_sign;
    }

    public void setIdSpecialty(int id_specialty) {
        this.idSpecialty = id_specialty;
    }
}
