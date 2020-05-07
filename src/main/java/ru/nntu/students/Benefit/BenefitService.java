package ru.nntu.students.Benefit;

import ru.nntu.students.Entrant.Entrant;

import java.util.List;

public interface BenefitService {
    public Benefit findById(int id);
    List getAllBenefits();
    public void saveBenefit(Benefit benefit);
    public int safeDelete(int id);
}
