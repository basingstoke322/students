package ru.nntu.students.Type_education;
import javax.persistence.*;

@Entity
@Table(name = "type_education")
public class Type_education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_education;
    private String educ_name;
    private int active_sign;

    protected Type_education(){}

    public Type_education(String educ_name){
        this.educ_name = educ_name;
        this.active_sign = 1;
    }

    public int getId_type_education(){
        return id_type_education;
    }
    public String getEduc_name(){
        return educ_name;
    }
    public int getActive_sign(){
        return active_sign;
    }
}
