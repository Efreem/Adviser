package ru.efreem.advisor.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.efreem.advisor.models.Collection;

import java.util.List;

@Repository
public interface CollectionRepository extends CrudRepository<Collection,Long> {
    @Query("SELECT * FROM Collection collections WHERE (collections.tag1 IN (?1)) OR (collections.tag2 IN (?1)) OR (collections.tag3 IN (?1)) GROUP BY views DESC")
    List<Collection> getPrerecommendationForCollections(String[] tags);
}
