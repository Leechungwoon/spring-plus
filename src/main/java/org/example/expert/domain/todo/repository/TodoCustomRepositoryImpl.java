package org.example.expert.domain.todo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.dto.response.UserResponse;

import java.util.Optional;

import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;

@RequiredArgsConstructor

public class TodoCustomRepositoryImpl implements  TodoCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser (Long todoId) {
        Todo result = (Todo) jpaQueryFactory
                .select(Projections.constructor(TodoResponse.class, todo.id, todo.title, todo.contents, todo.weather.stringValue(),
                Projections.constructor(UserResponse.class, user.id, user.email), todo.createdAt, todo.modifiedAt)
        )
                .from(todo)
                .leftJoin(todo.user, user).fetchJoin()
                .where(todo.id.eq(todoId))
                .fetch();
        return Optional.empty();
    }
}
