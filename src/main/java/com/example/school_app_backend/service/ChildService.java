package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ClassTeacherDTO;
import com.example.school_app_backend.dto.ScoreDTO;

import java.util.List;

public interface ChildService {
    List<ScoreDTO> getScoresForChild(String username);
    ClassTeacherDTO getTeacherDetailsForChild(String username);
}
