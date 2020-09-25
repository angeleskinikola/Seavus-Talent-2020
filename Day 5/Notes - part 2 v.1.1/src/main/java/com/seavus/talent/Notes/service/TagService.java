package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TagService {

    private TagRepository tagRepository;

    private SecurityService securityService;

    private NoteService noteService;

    private NoteRepository noteRepository;

    @Autowired
    public TagService(TagRepository tagRepository, SecurityService securityService, NoteService noteService,
                      NoteRepository noteRepository) {
        this.tagRepository = tagRepository;
        this.securityService = securityService;
        this.noteService = noteService;
        this.noteRepository = noteRepository;
    }

    public void createTag(String name) {
        User user = securityService.getAuthenticatedUser();
        tagRepository.save(new Tag(name, user));
    }

    public Optional<Tag> findTag(Long id) {
        User user = securityService.getAuthenticatedUser();
        Set<Tag> tags = tagRepository.findByUserId(user.getId());
        return tags.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Set<Tag> findTags(Long id) {
        return tagRepository.findByUserId(id);
    }

    public void deleteTag(Long id) {
        Set<Note> notes = noteService.findNotesByTagId(id);
        User user = securityService.getAuthenticatedUser();
        Set<Tag> tags = tagRepository.findByUserId(user.getId());

        Tag tag = tags.stream().filter(t -> t.getId().equals(id)).findFirst()
                .orElseThrow(IllegalArgumentException::new);

        notes.stream().filter(n -> n.getTags().remove(tag)).forEach(n -> noteRepository.save(n));

        tags.stream().filter(t -> t.getId().equals(id)).forEach(t -> tagRepository.deleteById(id));

    }
}
