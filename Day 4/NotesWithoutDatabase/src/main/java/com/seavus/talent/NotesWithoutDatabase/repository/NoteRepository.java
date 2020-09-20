package com.seavus.talent.NotesWithoutDatabase.repository;

import com.seavus.talent.NotesWithoutDatabase.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {

    private long nextId = 1;

    private ArrayList<Note> notes = new ArrayList<>();

    public void saveNote(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public Optional<Note> findNoteById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public List<Note> findAllNotes() {
        return notes;
    }

    public void updateNoteById(Long id, Note note) {
        for(int i = 0; i < notes.size(); i++) {
            if(notes.get(i).getId().equals(id)) {
                note.setId(id);
                notes.set(i, note);
                break;
            }
        }
    }

    public void deleteNoteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }
}
