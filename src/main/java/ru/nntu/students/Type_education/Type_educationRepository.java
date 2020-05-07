package ru.nntu.students.Type_education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nntu.students.Type_education.Type_education;

import java.util.List;

public interface Type_educationRepository extends JpaRepository<Type_education, Integer> {
    @Modifying
    @Query(value = "UPDATE Type_education set activeSign = 0 where idTypeEducation = :id")
    int safeDelete(@Param("id") int id);
    @Query(value = "FROM Type_education where activeSign = 1 order by idTypeEducation asc")
    List<Type_education> findAll();
}
