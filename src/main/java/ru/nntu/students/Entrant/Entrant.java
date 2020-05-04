package ru.nntu.students.Entrant;

import org.springframework.beans.factory.annotation.Autowired;
import ru.nntu.students.Specialty.Specialty;
import ru.nntu.students.Type_benefit.Type_benefit;
import ru.nntu.students.Type_benefit.Type_benefitServiceImpl;
import ru.nntu.students.blank.Blank;

import javax.persistence.*;

@Entity
@Table(name = "entrant")
public class Entrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrant;
    @ManyToOne
    @JoinColumn(name = "id_blank")
    private Blank blank;
    @ManyToOne
    @JoinColumn(name = "id_specialty")
    private Specialty specialty;
    @ManyToOne
    @JoinColumn(name = "id_benefits")
    private Type_benefit benefits;
    private int activeSign;

    public Entrant(){
        this.activeSign = 1;
    }

    public int getActiveSign() {
        return activeSign;
    }

    public Blank getBlank() {
        return blank;
    }

    public Specialty getSpecialty() { return specialty;}

    public Type_benefit getBenefits() {return benefits;}

    public int getIdEntrant() {return idEntrant;}

    public void setActiveSign(int activeSign) {
        this.activeSign = activeSign;
    }

    public void setBenefits(Type_benefit benefits) {
        this.benefits = benefits;
    }

    public void setBlank(Blank blank) {
        this.blank = blank;
    }

    public void setIdEntrant(int idEntrant) {
        this.idEntrant = idEntrant;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
