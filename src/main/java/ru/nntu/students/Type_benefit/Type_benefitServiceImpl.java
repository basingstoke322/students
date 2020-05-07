package ru.nntu.students.Type_benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findAll();
    }

    @Override
    public Type_benefit findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int safeDelete(int id) {
        return repository.safeDelete(id);
    }

    @Override
    public void saveTypeBenefit(Type_benefit type_benefit)  {
        repository.save(type_benefit);
    }

}
