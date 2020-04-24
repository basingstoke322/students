package ru.nntu.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService{
    private SpecialtyRepository repository;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAllSpecialties() {
        List list = new ArrayList();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public void saveSpecialty(Specialty specialty) {
        repository.save(specialty);
    }
}
