package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username=?2, u.password=?3 WHERE u.id=?1")
    void updateById(Long id, String username, String password);

    Optional<User> findByUsername(String username);
}
