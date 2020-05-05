package ru.nntu.students.Benefit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nntu.students.Entrant.Entrant;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
    @Query(value = "FROM Benefit where activeSign = 1 order by idBenefit asc")
    List<Benefit> findAll();
}
