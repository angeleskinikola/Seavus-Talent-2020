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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private SecurityService securityService;

    private TagRepository tagRepository;

    private UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, SecurityService securityService,
                       TagRepository tagRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.securityService = securityService;
        this.tagRepository = tagRepository;
    }

    public void createNote(String title, String content, List<Long> tagIdList) {
        User user = securityService.getAuthenticatedUser();
        List<Tag> tags = tagRepository.findAllById(tagIdList);
        noteRepository.save(new Note(title, content, user, tags));
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return noteRepository.findNotesByUserId(user.getId());
    }

    public void updateNote(Long id, String title, String content) {
        noteRepository.updateById(id, title, content);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findNotesByTagId(Long id) {
        return noteRepository.findNotesByTagId(id);
    }
}
