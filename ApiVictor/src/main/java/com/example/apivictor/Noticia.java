package com.example.apivictor;

public class Noticia {

    private String name, author, title, description, link, image;

    public Noticia(String name, String author, String title, String description, String link, String image) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.link = link;
        this.image = image;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
