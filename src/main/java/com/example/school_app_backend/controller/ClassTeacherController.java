package com.example.school_app_backend.controller;

import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.entity.Principal;
import com.example.school_app_backend.service.ClassTaecherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class-teacher")
public class ClassTeacherController {

    @Autowired
    private ClassTaecherService classTeacherService;


    @GetMapping("/scores")
    public ResponseEntity<List<ScoreDTO>> getClassScores(Principal principal) {
        List<ScoreDTO> scores = classTeacherService.getScoresForClassTeacher(principal.getName());
        return ResponseEntity.ok(scores);
    }
}
