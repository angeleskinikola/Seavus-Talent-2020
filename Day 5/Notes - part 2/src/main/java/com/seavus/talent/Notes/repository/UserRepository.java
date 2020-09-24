package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username=?2, u.password=?3 WHERE u.id=?1")
    void updateById(Long id, String username, String password);

    @Query("SELECT u.tags FROM User u WHERE u.id=?1")
    List<Tag> findTagByUserId(Long id);

    Optional<User> findByUsername(String username);
}
