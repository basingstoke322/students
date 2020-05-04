package ru.nntu.students.Type_benefit;
import javax.persistence.*;

@Entity
@Table(name = "type_benefit")
public class Type_benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeBenefit;
    private String benefitName;
    private int activeSign;

    protected Type_benefit(){}

    public Type_benefit(String benefitName){
        this.benefitName = benefitName;
        this.activeSign = 1;
    }

    public int getIdTypeBenefit(){
        return idTypeBenefit;
    }
    public String getBenefitName(){
        return benefitName;
    }
    public int getActiveSign(){
        return activeSign;
    }

    @Override
    public String toString(){
        return String.format("%s" , benefitName);
    }

    public void setActiveSign(int activeSign) {
        this.activeSign = activeSign;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public void setIdTypeBenefit(int idTypeBenefit) {
        this.idTypeBenefit = idTypeBenefit;
    }
}
