package ru.efreem.advisor.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.efreem.advisor.models.Test;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test,Long> {
    @Query("SELECT * FROM Test tests WHERE (tests.tag1 IN (?1)) OR (tests.tag2 IN (?1)) OR (tests.tag3 IN (?1)) GROUP BY views DESC")
    List<Test> getPrerecommendationForTests(String[] tags);
}
