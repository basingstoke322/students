package ru.nntu.students.Type_benefit;
import javax.persistence.*;

@Entity
@Table(name = "type_benefit")
public class Type_benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_benefit;
    private String benefit_name;
    private int active_sign;

    protected Type_benefit(){}

    public Type_benefit(String benefit_name){
        this.benefit_name = benefit_name;
        this.active_sign = 1;
    }

    public int getId_type_benefit(){
        return id_type_benefit;
    }
    public String getBenefit_name(){
        return benefit_name;
    }
    public int getActive_sign(){
        return active_sign;
    }
}
