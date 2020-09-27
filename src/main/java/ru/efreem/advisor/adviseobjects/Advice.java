package ru.efreem.advisor.adviseobjects;

import ru.efreem.advisor.models.Article;
import ru.efreem.advisor.models.Collection;
import ru.efreem.advisor.models.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Advice {
    private List<Article> articleAdviceList;
    private List<Collection> collectionAdviceList;
    private List<Test> testAdviceList;

    public static int MAXIMUM_ADVICE_SIZE = 8;

    public Advice() {
        this.articleAdviceList = new ArrayList<>();
        this.collectionAdviceList = new ArrayList<>();
        this.testAdviceList = new ArrayList<>();
    }

    public List<Article> getArticleAdviceList() {
        return articleAdviceList;
    }

    public void setArticleAdviceList(List<Article> articleAdviceList) {
        this.articleAdviceList = articleAdviceList;
    }

    public List<Collection> getCollectionAdviceList() {
        return collectionAdviceList;
    }

    public void setCollectionAdviceList(List<Collection> collectionAdviceList) {
        this.collectionAdviceList = collectionAdviceList;
    }

    public List<Test> getTestAdviceList() {
        return testAdviceList;
    }

    public void setTestAdviceList(List<Test> testAdviceList) {
        this.testAdviceList = testAdviceList;
    }

    public int size() {
        return articleAdviceList.size() + collectionAdviceList.size() + testAdviceList.size();
    }

    public String toString() {
        String result = "{Article:" + articleAdviceList.toString() + ", Collection:" + collectionAdviceList.toString() + ", Test:" + testAdviceList.toString();
        return result;
    }

    public void generateAdvice(List<Article> articles, List<Collection> collections, List<Test> tests, String type) {
        int ptr = 0;

        if (type == "article") {

            for (Article article : articles) {
                articleAdviceList.add(article);
            }

            if (size() != 8) {

                while (size() != MAXIMUM_ADVICE_SIZE) {
                    testAdviceList.add(tests.get(ptr));
                    ptr++;
                }

                ptr = 0;

                if (size() != MAXIMUM_ADVICE_SIZE) {

                    while (size() != 8) {
                        collectionAdviceList.add(collections.get(ptr));
                        ptr++;
                    }

                }
            }
        }

        else if (type == "test") {

            for (Test test : tests) {
                testAdviceList.add(test);
            }

            if (size() != 8) {

                while (size() != MAXIMUM_ADVICE_SIZE) {

                }

                ptr = 0;

                if (size() != MAXIMUM_ADVICE_SIZE) {

                    while (size() != 8) {
                        collectionAdviceList.add(collections.get(ptr));
                        ptr++;
                    }
                }
            }
        }
        else if (type == "collection") {

            for (Collection collection : collections) {
                collectionAdviceList.add(collection);
            }

            if (size() != 8) {

                while (size() != MAXIMUM_ADVICE_SIZE) {
                    articleAdviceList.add(articles.get(ptr));
                    ptr++;
                }

                ptr = 0;

                if (size() != MAXIMUM_ADVICE_SIZE) {

                    while (size() != 8) {
                        testAdviceList.add(tests.get(ptr));
                        ptr++;
                    }
                }
            }
        }
    }
}
