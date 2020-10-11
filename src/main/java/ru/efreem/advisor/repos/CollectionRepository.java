package ru.efreem.advisor.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.efreem.advisor.models.Collection;

import java.util.List;

@Repository
public interface CollectionRepository extends CrudRepository<Collection,Long> {
    @Query("SELECT collections FROM Collection collections WHERE ((collections.tag1 IN (?1,?2,?3)) OR (collections.tag2 IN (?1,?2,?3)) OR (collections.tag3 IN (?1,?2,?3))) AND id<>?4 GROUP BY views DESC")
    List<Collection> getPrerecommendationForCollections(String tag1, String tag2, String tag3, Long id);
}
