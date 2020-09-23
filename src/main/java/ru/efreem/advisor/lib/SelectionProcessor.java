package ru.efreem.advisor.lib;

import ru.efreem.advisor.models.Article;
import ru.efreem.advisor.models.Collection;
import ru.efreem.advisor.models.Test;

import java.util.*;

public class SelectionProcessor {

    public static List<Article> getArticleRecommendations(Article mainArticle,List<Article> articlePreRecommendations) {
        List<Article> result;
        String mainArticleText = mainArticle.getContent();
        mainArticleText = FrequentWordsAnalyzer.deleteAllNonCharacterAndNumberSymbolsFromText(mainArticleText);
        mainArticleText = FrequentWordsAnalyzer.deleteAllPronounsAndPrepositionsFromFormattedText(mainArticleText);
        String[] mainArticleTextArray = FrequentWordsAnalyzer.transformFormattedTextToFormattedTextArray(mainArticleText);
        String[] mainArticleMostFrequentWords = FrequentWordsAnalyzer.getMostFrequentWordsFromFormattedTextArray(mainArticleTextArray);

        Map<Article,Long> intersectionMapping = new HashMap<>();
        Set<String> mainArticleMostFrequentWordsSet = new HashSet<>(Arrays.asList(mainArticleMostFrequentWords));

        Set<String> mostFrequentWordsSet;
        Set<String> temp;
        String[] articleFormattedTextArray;
        String[] articleMostFrequentWords;

        //Заполнить intersectionMapping пре-рекомендованными статьями и количеством пересечений списков самых частых слов со списком текущей статьёй
        for(Article article : articlePreRecommendations) {
            String articleText = article.getContent();
            articleText = FrequentWordsAnalyzer.deleteAllNonCharacterAndNumberSymbolsFromText(articleText);
            articleText = FrequentWordsAnalyzer.deleteAllPronounsAndPrepositionsFromFormattedText(articleText);
            articleFormattedTextArray = FrequentWordsAnalyzer.transformFormattedTextToFormattedTextArray(articleText);
            articleMostFrequentWords = FrequentWordsAnalyzer.getMostFrequentWordsFromFormattedTextArray(articleFormattedTextArray);
            mostFrequentWordsSet = new HashSet<>(Arrays.asList(articleMostFrequentWords));
            temp = Set.copyOf(mostFrequentWordsSet);
            temp.retainAll(mainArticleMostFrequentWordsSet);
            intersectionMapping.put(article,(long)temp.size());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Article> getArticleRecommendations(Collection mainCollection, List<Article> articlePreRecommendations) {
        List<Article> result;

        Map<Article,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(mainCollection.getTag1());
        mainTags.add(mainCollection.getTag2());
        mainTags.add(mainCollection.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Article article : articlePreRecommendations) {
            tags.add(article.getTag1());
            tags.add(article.getTag2());
            tags.add(article.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(article,intersectionSize);

            tags.remove(article.getTag1());
            tags.remove(article.getTag2());
            tags.remove(article.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Article> getArticleRecommendations(Test mainTest, List<Article> articlePreRecommendations) {
        List<Article> result;

        Map<Article,Long> intersectionMapping = new HashMap<>();
        Collection temp;
        Set<String> mainTags = new HashSet<>();

        mainTags.add(mainTest.getTag1());
        mainTags.add(mainTest.getTag2());
        mainTags.add(mainTest.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Article article : articlePreRecommendations) {
            tags.add(article.getTag1());
            tags.add(article.getTag2());
            tags.add(article.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(article,intersectionSize);

            tags.remove(article.getTag1());
            tags.remove(article.getTag2());
            tags.remove(article.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Collection> getCollectionRecommendations(Collection mainCollection, List<Collection> collectionPreRecommendations) {
        List<Collection> result;

        Map<Collection,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(mainCollection.getTag1());
        mainTags.add(mainCollection.getTag2());
        mainTags.add(mainCollection.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Collection collection : collectionPreRecommendations) {
            tags.add(collection.getTag1());
            tags.add(collection.getTag2());
            tags.add(collection.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(collection,intersectionSize);

            tags.remove(collection.getTag1());
            tags.remove(collection.getTag2());
            tags.remove(collection.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Collection> getCollectionRecommendations(Article article, List<Collection> collectionPreRecommendations) {
        List<Collection> result;

        Map<Collection,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(article.getTag1());
        mainTags.add(article.getTag2());
        mainTags.add(article.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Collection collection : collectionPreRecommendations) {
            tags.add(collection.getTag1());
            tags.add(collection.getTag2());
            tags.add(collection.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(collection,intersectionSize);

            tags.remove(collection.getTag1());
            tags.remove(collection.getTag2());
            tags.remove(collection.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Collection> getCollectionRecommendations(Test test, List<Collection> collectionPreRecommendations) {
        List<Collection> result;

        Map<Collection,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(test.getTag1());
        mainTags.add(test.getTag2());
        mainTags.add(test.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Collection collection : collectionPreRecommendations) {
            tags.add(collection.getTag1());
            tags.add(collection.getTag2());
            tags.add(collection.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(collection,intersectionSize);

            tags.remove(collection.getTag1());
            tags.remove(collection.getTag2());
            tags.remove(collection.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Test> getTestRecommendations(Test mainTest, List<Test> testPreRecommendations) {
        List<Test> result;

        Map<Test,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(mainTest.getTag1());
        mainTags.add(mainTest.getTag2());
        mainTags.add(mainTest.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Test test : testPreRecommendations) {
            tags.add(test.getTag1());
            tags.add(test.getTag2());
            tags.add(test.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(test,intersectionSize);

            tags.remove(test.getTag1());
            tags.remove(test.getTag2());
            tags.remove(test.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Test> getTestRecommendations(Article article, List<Test> testPreRecommendations) {
        List<Test> result;

        Map<Test,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(article.getTag1());
        mainTags.add(article.getTag2());
        mainTags.add(article.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Test test : testPreRecommendations) {
            tags.add(test.getTag1());
            tags.add(test.getTag2());
            tags.add(test.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(test,intersectionSize);

            tags.remove(test.getTag1());
            tags.remove(test.getTag2());
            tags.remove(test.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }

    public static List<Test> getTestRecommendations(Collection collection, List<Test> testPreRecommendations) {
        List<Test> result;

        Map<Test,Long> intersectionMapping = new HashMap<>();
        Set<String> mainTags = new HashSet<>();

        mainTags.add(collection.getTag1());
        mainTags.add(collection.getTag2());
        mainTags.add(collection.getTag3());

        Set<String> tags = new HashSet<>();
        long intersectionSize;

        for (Test test : testPreRecommendations) {
            tags.add(test.getTag1());
            tags.add(test.getTag2());
            tags.add(test.getTag3());
            tags.retainAll(mainTags);

            intersectionSize = tags.size();
            intersectionMapping.put(test,intersectionSize);

            tags.remove(test.getTag1());
            tags.remove(test.getTag2());
            tags.remove(test.getTag3());
        }

        result = MaxValues.getSortedListByMax(intersectionMapping);
        return result;
    }
}
