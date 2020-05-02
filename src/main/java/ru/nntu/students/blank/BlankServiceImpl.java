package ru.nntu.students.blank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nntu.students.blank.Blank;
import ru.nntu.students.blank.BlankRepository;
import ru.nntu.students.blank.BlankService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlankServiceImpl implements BlankService {
    private  BlankRepository repository;

    @Autowired
    public BlankServiceImpl(BlankRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAllBlank() {
        List list = new ArrayList();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Blank findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveBlank(Blank blank) {
        repository.save(blank);
    }
}
