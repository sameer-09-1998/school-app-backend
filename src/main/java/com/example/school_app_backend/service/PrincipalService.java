package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ScoreDTO;

import java.util.List;
import java.util.Map;

public interface PrincipalService {

    Map<String, Double> getAverageScoresForClass(Long classId);

    List<ScoreDTO> getTopScoresBySubject(Long classId, String subject, int limit);

    List<ScoreDTO> getBottomScoresBySubject(Long classId, String subject, int limit);

    List<ScoreDTO> getSortedScoresBySubject(Long classId, String subject);

    Double getCumulativeAverageForClass(Long classId);
}
