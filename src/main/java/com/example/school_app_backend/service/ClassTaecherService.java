package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ScoreDTO;
import java.util.List;

public interface ClassTaecherService {

    List<ScoreDTO> getScoresForClassTeacher(String username);
}
