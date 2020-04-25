package ru.nntu.students.Type_education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List getAllTypesEducation() {
        List list = new ArrayList();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

//    @Override
//    public void saveSpecialty(Specialty specialty) {
//        repository.save(specialty);
//    }
}
