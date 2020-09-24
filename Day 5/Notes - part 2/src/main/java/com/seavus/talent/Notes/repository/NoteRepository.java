package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Note n SET n.title=?2, n.content=?3 WHERE n.id=?1")
    void updateById(Long id, String title, String content);

    @Query("SELECT t.notes FROM Tag t WHERE t.id=?1")
    List<Note> findNotesByTagId(Long id);

    @Query("SELECT u.notes FROM User u WHERE u.id=?1")
    List<Note> findNotesByUserId(Long id);
}