package com.seavus.talent.Notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public List<Note> getNotes() {
        return notes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonIgnore
    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
