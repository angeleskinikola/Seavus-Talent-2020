package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
        public Set<Long> tags;

    }

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {
        return noteService.createNote(request.title, request.content,
                request.tags != null ? request.tags : new HashSet<>());
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/tags/{id}/notes")
    public Set<Note> findNotesByTagId(@PathVariable Long id) {
        return noteService.findNotesByTagId(id);
    }

    @GetMapping("/api/notes")
    public Set<Note> findNotes() {
        return noteService.findNotes();
    }

    @PutMapping("/api/notes/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        return noteService.updateNote(id, request.title, request.content,
                request.tags != null ? request.tags : new HashSet<>());
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
