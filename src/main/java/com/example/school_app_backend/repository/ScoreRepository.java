package com.example.school_app_backend.repository;

import com.example.school_app_backend.entity.Child;
import com.example.school_app_backend.entity.Score;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByChild(Child child);

    @Query("SELECT s.subject as subject, AVG(s.score) as avgScore " +
            "FROM Score s " +
            "WHERE s.child.classId = :classId " +
            "GROUP BY s.subject")
    List<Object[]> findAverageScoresBySubjectForClass(@Param("classId") Long classId);

    @Query("SELECT s FROM Score s " +
            "WHERE s.subject = :subject AND s.child.classId = :classId " +
            "ORDER BY s.score DESC")
    List<Score> findTopScoresBySubjectAndClass(@Param("subject") String subject,
                                               @Param("classId") Long classId,
                                               Pageable pageable);

    @Query("SELECT s FROM Score s " +
            "WHERE s.subject = :subject AND s.child.classId = :classId " +
            "ORDER BY s.score ASC")
    List<Score> findBottomScoresBySubjectAndClass(@Param("subject") String subject,
                                                  @Param("classId") Long classId,
                                                  Pageable pageable);

    @Query("SELECT s FROM Score s " +
            "WHERE s.subject = :subject AND s.child.classId = :classId " +
            "ORDER BY s.score DESC")
    List<Score> findSortedScoresBySubjectAndClass(@Param("subject") String subject,
                                                  @Param("classId") Long classId);

    @Query("SELECT AVG(s.score) FROM Score s WHERE s.child.classId = :classId")
    Double findCumulativeAverageByClass(@Param("classId") Long classId);

    List<Score> findByChild_ClassId(Long classId);
}
