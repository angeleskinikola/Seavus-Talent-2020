package com.seavus.talent.NotesWithoutDatabase.service;

import com.seavus.talent.NotesWithoutDatabase.model.Note;
import com.seavus.talent.NotesWithoutDatabase.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(String title, String content) {
        noteRepository.saveNote(new Note(title, content));
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findNoteById(id);
    }

    public List<Note> findNotes() {
        return noteRepository.findAllNotes();
    }

    public void updateNote(Long id, String title, String content) {
        noteRepository.updateNoteById(id, title, content);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteNoteById(id);
    }
}
