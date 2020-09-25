package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT u.tags FROM User u WHERE u.id=?1")
    Set<Tag> findByUserId(Long id);
}
