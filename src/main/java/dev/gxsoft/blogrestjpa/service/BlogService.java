package dev.gxsoft.blogrestjpa.service;

import dev.gxsoft.blogrestjpa.model.Comment;
import dev.gxsoft.blogrestjpa.model.Post;
import dev.gxsoft.blogrestjpa.model.User;

import java.util.List;

public interface BlogService {

    List<Post> findAllPost();
    Post findPostById(long id);
    String addPost(long userId, Post post);
    void saveUser(User user);
    List<Post> getAllPostsByUserId(long userId);
    List<Comment> getCommentByPost(long postId);
    Comment addCommentInPost(long postId, Comment comment);
    User updateUser(long userId, User user);
    Post deletePostByPostId(long postId);
}
