package com.example.school_app_backend.repository;

import com.example.school_app_backend.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassrepository extends JpaRepository<SchoolClass, Long> {

}
