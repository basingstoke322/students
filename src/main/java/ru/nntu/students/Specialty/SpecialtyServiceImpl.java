package ru.nntu.students.Specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return repository.findAll(Sort.by(Sort.Direction.ASC, "idSpecialty"));
    }

    @Override
    public Specialty findById(int id) {
        return repository.findById(id).get();
    }



    @Override
    public void saveSpecialty(Specialty specialty) {
            repository.save(specialty);
    }
}
