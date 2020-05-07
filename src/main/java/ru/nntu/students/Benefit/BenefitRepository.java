package ru.nntu.students.Benefit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nntu.students.Entrant.Entrant;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
    @Query(value = "FROM Benefit where activeSign = 1 order by idBenefit asc")
    List<Benefit> findAll();
    @Modifying
    @Query(value = "UPDATE Benefit set activeSign = 0 where idBenefit = :id")
    int safeDelete(@Param("id") int id);
}
