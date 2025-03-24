package com.example.school_app_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "scores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
