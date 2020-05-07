package ru.nntu.students.Specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
//        return repository.findAll(Sort.by(Sort.Direction.ASC, "idSpecialty"));
        return repository.findAll();
    }

    @Override
    public Specialty findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int safeDelete(int id) {
        return repository.safeDelete(id);
    }

    @Override
    public void saveSpecialty(Specialty specialty) {
            repository.save(specialty);
    }
}
