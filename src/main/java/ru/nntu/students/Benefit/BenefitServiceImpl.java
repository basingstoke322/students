package ru.nntu.students.Benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
