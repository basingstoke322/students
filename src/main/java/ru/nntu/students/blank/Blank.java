package ru.nntu.students.blank;

import javax.persistence.*;

@Entity
@Table(name = "blank")
public class Blank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBlank;
    private String firstName;
    private String lastName;
    private String otc;
    private String bday;
    private String city;
    private int examResults;
    private int activeSign;

    protected Blank(){}

    public Blank(String firstName, String lastName, String otc, String bday, String city, int examResults){
        this.firstName = firstName;
        this.lastName = lastName;
        this.otc = otc;
        this.bday = bday;
        this.examResults = examResults;
        this.city = city;
        this.activeSign = 1;
    }

    public int getIdBlank(){return idBlank;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getOtc(){return otc;}
    public String getBday(){return bday;}
    public String getCity(){return city;}
    public int getExamResults(){return examResults;}
    public int getActiveSign(){return activeSign;}
    @Override
    public String toString(){
        return String.format("%s %s %s %s", firstName, lastName, otc, bday);
    }


    public void setFirstName(String firstName) { this.firstName = firstName;}
    public void setLastName(String lastName) { this.lastName = lastName;}
    public void setOtc(String otc) {this.otc = otc;}
    public void setBday(String bday) {this.bday = bday;}
    public void setExamResults(int examResults) {this.examResults = examResults;}
    public void setCity(String city) {this.city = city;}
    public void setActiveSign(int activeSign) {this.activeSign = activeSign;}
    public void setIdBlank(int idBlank) {this.idBlank = idBlank;}
}

