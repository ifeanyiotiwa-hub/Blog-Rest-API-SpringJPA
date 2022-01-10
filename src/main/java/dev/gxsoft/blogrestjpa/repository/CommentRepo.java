package dev.gxsoft.blogrestjpa.repository;

import dev.gxsoft.blogrestjpa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(long postId);
}
