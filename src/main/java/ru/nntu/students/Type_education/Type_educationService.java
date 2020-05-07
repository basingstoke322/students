package ru.nntu.students.Type_education;

import ru.nntu.students.Type_education.Type_education;

import java.util.List;

public interface Type_educationService {
    List getAllTypeEducation();
    Type_education findById(int id);
    void saveTypeEducation(Type_education type_education);
    int safeDelete(int id);
}

