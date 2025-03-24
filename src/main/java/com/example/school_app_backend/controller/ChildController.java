package com.example.school_app_backend.controller;

import com.example.school_app_backend.dto.ClassTeacherDTO;
import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.entity.Principal;
import com.example.school_app_backend.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/child")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping("/scores")
    public ResponseEntity<List<ScoreDTO>> getChildScores(Principal principal) {

        List<ScoreDTO> scores = childService.getScoresForChild(principal.getName());
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/teacher")
    public ResponseEntity<ClassTeacherDTO> getTeacherDetails(Principal principal) {
        ClassTeacherDTO teacher = childService.getTeacherDetailsForChild(principal.getName());
        return ResponseEntity.ok(teacher);
    }
}
