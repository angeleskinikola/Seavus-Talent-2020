package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.repository.UserRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private SecurityService securityService;

    private TagRepository tagRepository;


    @Autowired
    public NoteService(NoteRepository noteRepository, SecurityService securityService, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.securityService = securityService;
        this.tagRepository = tagRepository;
    }

    public Note createNote(String title, String content, Set<Long> tagIdSet) {
        User user = securityService.getAuthenticatedUser();
        Set<Tag> tags = tagRepository.findAllById(tagIdSet)
                .stream().filter(tag -> tag.getUser().equals(user))
                .collect(Collectors.toSet());
        return noteRepository.save(new Note(title, content, user, tags));
    }

    public Optional<Note> findNote(Long id) {
        User user = securityService.getAuthenticatedUser();
        Set<Note> notes = noteRepository.findNotesByUserId(user.getId());
        return notes.stream().filter(n -> n.getId().equals(id)).findFirst();
    }

    public Set<Note> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return noteRepository.findNotesByUserId(user.getId());
    }

    public Note updateNote(Long id, String title, String content, Set<Long> tagIdSet) {
        User user = securityService.getAuthenticatedUser();

        Set<Tag> tags = tagRepository.findAllById(tagIdSet).stream()
                .filter(t -> t.getUser().equals(user)).collect(Collectors.toSet());

        Set<Note> notes = noteRepository.findNotesByUserId(user.getId());

        Note note = notes.stream().filter(n -> n.getId().equals(id)).findFirst()
                .orElseThrow(IllegalArgumentException::new);

        note.setTitle(title);
        note.setContent(content);
        note.setTags(tags);

        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        User user = securityService.getAuthenticatedUser();
        Set<Note> notes = noteRepository.findNotesByUserId(user.getId());
        Note note = notes.stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new);
        noteRepository.deleteById(note.getId());
    }

    public Set<Note> findNotesByTagId(Long id) {
        User user = securityService.getAuthenticatedUser();
        return noteRepository.findNotesByTagId(id).stream()
                .filter(note -> note.getUser().equals(user))
                .collect(Collectors.toSet());
    }
}
