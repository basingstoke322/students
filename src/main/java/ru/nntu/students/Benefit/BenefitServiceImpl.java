package ru.nntu.students.Benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nntu.students.Entrant.Entrant;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class BenefitServiceImpl implements BenefitService{
    private BenefitRepository repository;

    @Autowired
    public BenefitServiceImpl(BenefitRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAllBenefits() {
        return repository.findAll();
    }

    @Override
    public int safeDelete(int id) {
        return repository.safeDelete(id);
    }

    @Override
    public void saveBenefit(Benefit benefit) {
        repository.save(benefit);
    }

    @Override
    public Benefit findById(int id) {
        return repository.findById(id).get();
    }

}
