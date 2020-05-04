package ru.nntu.students.Entrant;

import ru.nntu.students.Specialty.Specialty;

import java.util.List;

public interface EntrantService {
    public Entrant findById(int id);
    public List getAllEntrants();
    public void saveEntrant(Entrant entrant);
    public int safeDelete(int id);
}
