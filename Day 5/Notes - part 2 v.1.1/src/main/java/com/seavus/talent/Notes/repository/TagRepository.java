package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("from Tag t where t.user.id = ?1")
    List<Tag> findTagByUserId(Long id);

    @Query("SELECT u.tags FROM User u WHERE u.id=?1")
    List<Tag> findByUserId(Long id);
}
