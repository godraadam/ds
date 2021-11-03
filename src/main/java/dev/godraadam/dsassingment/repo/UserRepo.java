package dev.godraadam.dsassingment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {

    @SuppressWarnings("checkstyle:MethodName")
    Optional<AppUser> findByAccountDetails_Email(String email);
}
