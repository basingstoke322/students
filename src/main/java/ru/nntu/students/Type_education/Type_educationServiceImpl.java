package ru.nntu.students.Type_education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nntu.students.Type_education.Type_education;
import ru.nntu.students.Type_education.Type_educationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Type_educationServiceImpl implements Type_educationService{
    private Type_educationRepository repository;

    @Autowired
    public Type_educationServiceImpl(Type_educationRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAllTypeEducation() {
        return repository.findAll();
    }

    @Override
    public Type_education findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int safeDelete(int id) {
        return repository.safeDelete(id);
    }

    @Override
    public void saveTypeEducation(Type_education type_education) {
        repository.save(type_education);
    }
}
