package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT t.notes FROM Tag t WHERE t.id=?1")
    Set<Note> findNotesByTagId(Long id);

    @Query("SELECT u.notes FROM User u WHERE u.id=?1")
    Set<Note> findNotesByUserId(Long id);
}