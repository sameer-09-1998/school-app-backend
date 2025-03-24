package com.example.school_app_backend.repository;

import com.example.school_app_backend.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child, Long> {
    Optional<Child> findByUsername(String username);
}
