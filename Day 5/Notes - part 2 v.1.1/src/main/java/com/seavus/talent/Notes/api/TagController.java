package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.security.SecurityService;
import com.seavus.talent.Notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TagController {

    private TagService tagService;

    private SecurityService securityService;

    @Autowired
    public TagController(TagService tagService, SecurityService securityService) {
        this.tagService = tagService;
        this.securityService = securityService;
    }

    public static class CreateTagRequest {
        public String name;
    }

    @PostMapping("/api/tags")
    public void createTag(@RequestBody CreateTagRequest request) {
        tagService.createTag(request.name);
    }

    @GetMapping("/api/tags/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/tags")
    public List<Tag> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return tagService.findTags(user.getId());
    }

    @DeleteMapping("/api/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
