package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.entity.Score;
import com.example.school_app_backend.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PrincipalServiceImpl implements PrincipalService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Map<String, Double> getAverageScoresForClass(Long classId) {
        Map<String, Double> averages = new HashMap<>();

        List<Object[]> results = scoreRepository.findAverageScoresBySubjectForClass(classId);
        for (Object[] result : results) {
            String subject = (String) result[0];
            Double avgScore = (Double) result[1];
            averages.put(subject, avgScore);
        }
        return averages;
    }

    @Override
    public List<ScoreDTO> getTopScoresBySubject(Long classId, String subject, int limit) {

        List<Score> topScores = scoreRepository.findTopScoresBySubjectAndClass(subject, classId, PageRequest.of(0, limit));
        return topScores.stream()
                .map(score -> new ScoreDTO(score.getSubject(), score.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreDTO> getBottomScoresBySubject(Long classId, String subject, int limit) {
        // Using PageRequest to limit the results
        List<Score> bottomScores = scoreRepository.findBottomScoresBySubjectAndClass(subject, classId, PageRequest.of(0, limit));
        return bottomScores.stream()
                .map(score -> new ScoreDTO(score.getSubject(), score.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreDTO> getSortedScoresBySubject(Long classId, String subject) {
        // Retrieves the complete sorted list in descending order.
        List<Score> sortedScores = scoreRepository.findSortedScoresBySubjectAndClass(subject, classId);
        return sortedScores.stream()
                .map(score -> new ScoreDTO(score.getSubject(), score.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public Double getCumulativeAverageForClass(Long classId) {
        return scoreRepository.findCumulativeAverageByClass(classId);
    }
}
