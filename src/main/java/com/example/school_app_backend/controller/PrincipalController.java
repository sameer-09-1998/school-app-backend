package com.example.school_app_backend.controller;

import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    @GetMapping("/averages/{classId}")
    public ResponseEntity<Map<String, Double>> getAverageScores(@PathVariable Long classId) {
        Map<String, Double> averages = principalService.getAverageScoresForClass(classId);
        return ResponseEntity.ok(averages);
    }

    @GetMapping("/top-scores/{classId}/{subject}")
    public ResponseEntity<List<ScoreDTO>> getTopScores(@PathVariable Long classId,
                                                       @PathVariable String subject,
                                                       @RequestParam(defaultValue = "3") int limit) {
        List<ScoreDTO> topScores = principalService.getTopScoresBySubject(classId, subject, limit);
        return ResponseEntity.ok(topScores);
    }


    @GetMapping("/bottom-scores/{classId}/{subject}")
    public ResponseEntity<List<ScoreDTO>> getBottomScores(@PathVariable Long classId,
                                                          @PathVariable String subject,
                                                          @RequestParam(defaultValue = "3") int limit) {
        List<ScoreDTO> bottomScores = principalService.getBottomScoresBySubject(classId, subject, limit);
        return ResponseEntity.ok(bottomScores);
    }

    @GetMapping("/sorted-scores/{classId}/{subject}")
    public ResponseEntity<List<ScoreDTO>> getSortedScores(@PathVariable Long classId,
                                                          @PathVariable String subject) {
        List<ScoreDTO> sortedScores = principalService.getSortedScoresBySubject(classId, subject);
        return ResponseEntity.ok(sortedScores);
    }

    @GetMapping("/cumulative-average/{classId}")
    public ResponseEntity<Double> getCumulativeAverage(@PathVariable Long classId) {
        Double cumulativeAverage = principalService.getCumulativeAverageForClass(classId);
        return ResponseEntity.ok(cumulativeAverage);
    }
}
