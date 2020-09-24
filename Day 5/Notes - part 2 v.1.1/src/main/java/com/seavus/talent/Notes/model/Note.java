package com.seavus.talent.Notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Tag> tags;

    public Note() {
    }

    public Note(String title, String content, User user, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Note:" +
                "\nid = " + id +
                "\ntitle = " + title  +
                "\ncontent = " + content;
    }
}

