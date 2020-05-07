package ru.nntu.students.Type_benefit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Type_benefitRepository extends JpaRepository<Type_benefit, Integer> {
    @Modifying
    @Query(value = "UPDATE Type_benefit set activeSign = 0 where idTypeBenefit = :id")
    int safeDelete(@Param("id") int id);
    @Query(value = "FROM Type_benefit where activeSign = 1 order by idTypeBenefit asc")
    List<Type_benefit> findAll();
}
