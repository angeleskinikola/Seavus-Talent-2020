package com.seavus.talent.Notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "tags")
    private List<Note> notes;

    public Tag() {
    }

    public Tag(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Note> getNotes() {
        return notes;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
