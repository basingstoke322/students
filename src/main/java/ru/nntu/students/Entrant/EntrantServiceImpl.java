package ru.nntu.students.Entrant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EntrantServiceImpl implements EntrantService{
    private EntrantRepository repository;

    @Autowired
    public EntrantServiceImpl(EntrantRepository repository){
        this.repository = repository;
    }

    @Override
    public Entrant findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List getAllEntrants() {
        return repository.findAll();
    }

    @Override
    public void saveEntrant(Entrant entrant) {
        repository.save(entrant);
    }

    @Override
    public int safeDelete(int id) {
        return repository.safeDelete(id);
    }
}
