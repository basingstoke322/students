package ru.nntu.students.Specialty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
    @Modifying
    @Query(value = "UPDATE Specialty set activeSign = 0 where idSpecialty = :id")
    int safeDelete(@Param("id") int id);
    @Query(value = "FROM Specialty where activeSign = 1 order by idSpecialty asc")
    List<Specialty> findAll();
}

