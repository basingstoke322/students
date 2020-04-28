package ru.nntu.students.Specialty;


import java.util.List;

public interface SpecialtyService {
    public List getAllSpecialties();
    public Specialty findById(int id);
    public void saveSpecialty(Specialty specialty);
}
