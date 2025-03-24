package com.example.school_app_backend.repository;

import com.example.school_app_backend.entity.ClassTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, Long> {
    Optional<ClassTeacher> findByClassId(Long classId);
    Optional<ClassTeacher> findByUsername(String username);
}
