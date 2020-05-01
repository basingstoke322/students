package ru.nntu.students.Type_education;
import javax.persistence.*;

@Entity
@Table(name = "type_education")
public class Type_education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeEducation;
    private String educName;
    private int activeSign;

    protected Type_education(){}

    public Type_education(String educName){
        this.educName = educName;
        this.activeSign = 1;
    }

    public int getIdTypeEducation(){
        return idTypeEducation;
    }
    public String getEducName(){
        return educName;
    }
    public int getActiveSign(){
        return activeSign;
    }
}
