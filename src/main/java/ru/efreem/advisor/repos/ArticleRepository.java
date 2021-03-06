package ru.efreem.advisor.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.efreem.advisor.models.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Query("SELECT articles FROM Article articles WHERE ((articles.tag1 IN (?1,?2,?3)) OR (articles.tag2 IN (?1,?2,?3)) OR (articles.tag3 IN (?1,?2,?3))) AND id<>?4 GROUP BY views DESC")
    List<Article> getPrerecommendationForArticles(String tag1, String tag2, String tag3, Long id);
}
