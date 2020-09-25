package ru.efreem.advisor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.efreem.advisor.adviseobjects.Advice;
import ru.efreem.advisor.lib.SelectionProcessor;
import ru.efreem.advisor.models.Article;
import ru.efreem.advisor.models.Collection;
import ru.efreem.advisor.models.Test;
import ru.efreem.advisor.repos.ArticleRepository;
import ru.efreem.advisor.repos.CollectionRepository;
import ru.efreem.advisor.repos.TestRepository;

import java.util.List;

@RestController
public class AdviceController {
    @Autowired
    private ArticleRepository articleRepo;
    @Autowired
    private CollectionRepository collectionRepo;
    @Autowired
    private TestRepository testRepo;

    @GetMapping("/")
    public Advice getAdvises(@RequestParam String tags, @RequestParam Long id, @RequestParam String type) {
        Advice advice = new Advice();

        Article article;
        Collection collection;
        Test test;

        List<Article> articlePreRecommendations = articleRepo.getPrerecommendationForArticles(tags.split(","));
        List<Collection> collectionPreRecommendations = collectionRepo.getPrerecommendationForCollections(tags.split(","));
        List<Test> testPreRecommendations = testRepo.getPrerecommendationForTests(tags.split(","));

        List<Article> articleRecommendations;
        List<Collection> collectionRecommendations;
        List<Test> testRecommendations;

        if (type == "article") {

            if (articleRepo.existsById(id)) {
                article = articleRepo.findById(id).get();

                articleRecommendations = SelectionProcessor.getArticleRecommendations(article, articlePreRecommendations);
                collectionRecommendations = SelectionProcessor.getCollectionRecommendations(article, collectionPreRecommendations);
                testRecommendations = SelectionProcessor.getTestRecommendations(article, testPreRecommendations);
            } else {
                return advice;
            }

        }
        else if (type == "collection") {

            if (collectionRepo.existsById(id)) {
                collection = collectionRepo.findById(id).get();

                articleRecommendations = SelectionProcessor.getArticleRecommendations(collection, articlePreRecommendations);
                collectionRecommendations = SelectionProcessor.getCollectionRecommendations(collection, collectionPreRecommendations);
                testRecommendations = SelectionProcessor.getTestRecommendations(collection, testPreRecommendations);
            } else {
                return advice;
            }

        }

        else if (type == "test") {

            if (testRepo.existsById(id)) {
                test = testRepo.findById(id).get();

                articleRecommendations = SelectionProcessor.getArticleRecommendations(test, articlePreRecommendations);
                collectionRecommendations = SelectionProcessor.getCollectionRecommendations(test, collectionPreRecommendations);
                testRecommendations = SelectionProcessor.getTestRecommendations(test, testPreRecommendations);
            } else {
                return advice;
            }

        }

        else {
            return advice;
        }

        advice.generateAdvice(articleRecommendations, collectionRecommendations, testRecommendations, type);
        return advice;
    }
}
