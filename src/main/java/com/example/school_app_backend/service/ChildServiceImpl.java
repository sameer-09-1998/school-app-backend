package com.example.school_app_backend.service;

import com.example.school_app_backend.dto.ClassTeacherDTO;
import com.example.school_app_backend.dto.ScoreDTO;
import com.example.school_app_backend.entity.Child;
import com.example.school_app_backend.entity.ClassTeacher;
import com.example.school_app_backend.entity.Score;
import com.example.school_app_backend.repository.ChildRepository;
import com.example.school_app_backend.repository.ClassTeacherRepository;
import com.example.school_app_backend.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ClassTeacherRepository teacherRepository;

    @Override
    public List<ScoreDTO> getScoresForChild(String username) {
        Child child = childRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Child not found"));
        List<Score> scores = scoreRepository.findByChild(child);
        return scores.stream()
                .map(score -> new ScoreDTO(score.getSubject(), score.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public ClassTeacherDTO getTeacherDetailsForChild(String username) {
        Child child = childRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Child not found"));
        ClassTeacher teacher = teacherRepository.findByClassId(child.getClassId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return new ClassTeacherDTO(teacher.getName(), teacher.getEmail());
    }
}
