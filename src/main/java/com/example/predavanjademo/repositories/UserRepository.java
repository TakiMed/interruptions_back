package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // definisemo po tome kako ide JPA dokumentacija
    // Optional koristimo da izbjegnemo null
    Optional<User> findByUsernameLike(String username);

    List<User> findByIsActiveIsTrue();

    List<User> findByCreatedAtBefore(Date createdAt);

    boolean existsByFirstNameStartingWith(String firstName);

    @Query("select user from User user " +
            "join user.roles role " +
            "where role.name = :roleName")
    List<User> getAllByRoleName(@Param("roleName") String roleName);

    User findByUsername(String username);
}
