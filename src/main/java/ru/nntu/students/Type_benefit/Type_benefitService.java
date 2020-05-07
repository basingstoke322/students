package ru.nntu.students.Type_benefit;

import java.util.List;

public interface Type_benefitService {
    List getAllTypesBenefit();
    Type_benefit findById(int id);
    void saveTypeBenefit(Type_benefit type_benefit);
    int safeDelete(int id);
}

