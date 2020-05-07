package ru.nntu.students.blank;


import java.util.List;

public interface BlankService {
    public List getAllBlank();
    public Blank findById(int id);
    public void saveBlank(Blank blank);
    int safeDelete(int id);
}