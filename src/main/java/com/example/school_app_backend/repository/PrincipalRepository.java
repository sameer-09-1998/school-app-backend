package com.example.school_app_backend.repository;

import com.example.school_app_backend.entity.Principal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
    Optional<Principal> findByUsername(String username);
}
