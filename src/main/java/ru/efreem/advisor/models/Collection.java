package ru.efreem.advisor.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String name;
    private String tag1;
    private String tag2;
    private String tag3;

    @OneToMany
    private Set<Article> articleSet;
    @OneToMany
    private Set<Test> testSet;

    private Integer views;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public Set<Test> getTestSet() {
        return testSet;
    }

    public void setTestSet(Set<Test> testSet) {
        this.testSet = testSet;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Collection prototype() {
        Collection result = new Collection();

        result.setId(this.id);
        result.setAuthor(this.author);
        result.setName(this.name);
        result.setTag1(this.tag1);
        result.setTag2(this.tag2);
        result.setTag3(this.tag3);
        result.setArticleSet(this.articleSet);
        result.setTestSet(this.testSet);
        result.setViews(this.views);
        
        return result;
    }
}
