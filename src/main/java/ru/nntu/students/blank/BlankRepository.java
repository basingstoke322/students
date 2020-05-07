package ru.nntu.students.blank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nntu.students.Specialty.Specialty;

import java.util.List;
@Repository
public interface BlankRepository extends JpaRepository<Blank, Integer> {
    @Modifying
    @Query(value = "UPDATE Blank set activeSign = 0 where idBlank = :id")
    int safeDelete(@Param("id") int id);
    @Query(value = "FROM Blank where activeSign = 1 order by idBlank asc")
    List<Blank> findAll();
}