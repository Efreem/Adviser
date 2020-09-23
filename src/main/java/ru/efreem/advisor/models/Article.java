package ru.efreem.advisor.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

//Как примерно выглядит модель статьи
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String name;
    private String tag1;
    private String tag2;
    private String tag3;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean equals(Article article) {
        if (this.id.equals(article.getId())) {
            return true;
        } else {
            return false;
        }
    }

    public Article prototype() {
        Article result = new Article();

        result.setId(this.id);
        result.setAuthor(this.author);
        result.setName(this.name);
        result.setTag1(this.tag1);
        result.setTag2(this.tag2);
        result.setTag3(this.tag3);
        result.setContent(this.content);
        result.setViews(this.views);

        return result;
    }
}
