package ru.nntu.students.Benefit;

import ru.nntu.students.Type_benefit.Type_benefit;
import ru.nntu.students.Type_education.Type_education;

import javax.persistence.*;

@Entity
@Table(name = "benefits")
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBenefit;
    @ManyToOne
    @JoinColumn(name = "id_type_education")
    private Type_education education;
    @ManyToOne
    @JoinColumn(name = "id_type_benefit")
    private Type_benefit benefits;

    private int activeSign;

    public Benefit(){
        this.activeSign = 1;
    }

    public int getActiveSign() {
        return activeSign;
    }

    public Type_benefit getBenefits() {return benefits;}

    public Type_education getEducation() {return education;}

    public int getIdBenefit() {return idBenefit;}
    @Override
    public String toString(){
        return String.format("%s" ,education + "||" + benefits);
    }

    public void setActiveSign(int activeSign) {
        this.activeSign = activeSign;
    }

    public void setBenefits(Type_benefit benefits) {
        this.benefits = benefits;
    }

    public void setEducation(Type_education education) {
        this.education = education;
    }

    public void setIdBenefit(int idBenefit) {
        this.idBenefit = idBenefit;
    }
}
