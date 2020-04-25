package ru.nntu.students.Type_benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Type_benefitServiceImpl implements Type_benefitService{
    private Type_benefitRepository repository;

    @Autowired
    public Type_benefitServiceImpl(Type_benefitRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAllTypesBenefit() {
        List list = new ArrayList();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

//    @Override
//    public void saveSpecialty(Specialty specialty) {
//        repository.save(specialty);
//    }
}
