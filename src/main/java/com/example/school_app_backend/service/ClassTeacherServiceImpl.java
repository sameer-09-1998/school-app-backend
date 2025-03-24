package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.entity.ClassTeacher;
import com.example.school_app_backend.entity.Score;
import com.example.school_app_backend.repository.ClassTeacherRepository;
import com.example.school_app_backend.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClassTeacherServiceImpl implements ClassTaecherService{
    @Autowired
    private ClassTeacherRepository classTeacherRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<ScoreDTO> getScoresForClassTeacher(String username) {

        ClassTeacher teacher = classTeacherRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("ClassTeacher not found with username: " + username));

        List<Score> scores = scoreRepository.findByChild_ClassId(teacher.getClassId());

        return scores.stream()
                .map(score -> new ScoreDTO(score.getSubject(), score.getScore()))
                .collect(Collectors.toList());
    }
}
