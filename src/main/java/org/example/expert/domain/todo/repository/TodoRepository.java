package org.example.expert.domain.todo.repository;

import org.example.expert.domain.comment.entity.QComment;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

//    @Query("SELECT t FROM Todo t " +
//            "LEFT JOIN t.user " +
//            "WHERE t.id = :todoId")
//    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);


//   날짜만 검색
    Page<Todo> findByWeatherOrderByModifiedAtDesc(String weather, Pageable pageable);

//    기간만 검색
//    Page<Todo> findByPeriod(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);


    //날씨 + 기간 검색
    Page<Todo> findByWeatherAndModifiedAtBetweenOrderByModifiedAtDesc(String weather, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Todo> findByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);


    Optional<Todo> findByIdWithUser(long todoId);
}
