package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;

    private SecurityService securityService;

    @Autowired
    public TagService(TagRepository tagRepository, SecurityService securityService) {
        this.tagRepository = tagRepository;
        this.securityService = securityService;
    }

    public void createTag(String name) {
        User user = securityService.getAuthenticatedUser();
        tagRepository.save(new Tag(name, user));
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findTags(Long id) {
        return tagRepository.findByUserId(id);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
