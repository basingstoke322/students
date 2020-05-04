package ru.nntu.students.Entrant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntrantRepository extends JpaRepository<Entrant, Integer> {
    @Modifying
    @Query(value = "UPDATE Entrant set activeSign = 0 where idEntrant = :id")
    int safeDelete(@Param("id") int id);
    @Query(value = "FROM Entrant where activeSign = 1 order by idEntrant asc")
    List<Entrant> findAll();
}
