package dev.gxsoft.blogrestjpa.serviceimpl;

import dev.gxsoft.blogrestjpa.model.Comment;
import dev.gxsoft.blogrestjpa.model.Post;
import dev.gxsoft.blogrestjpa.model.User;
import dev.gxsoft.blogrestjpa.repository.CommentRepo;
import dev.gxsoft.blogrestjpa.repository.PostRepo;
import dev.gxsoft.blogrestjpa.repository.UserRepo;
import dev.gxsoft.blogrestjpa.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class BlogServiceImpl implements BlogService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final CommentRepo commentRepo;


    @Autowired
    public BlogServiceImpl(UserRepo UserRepo, PostRepo postRepo, CommentRepo commentRepo) {
        this.userRepo = UserRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    public List<Post> findAllPost(){
        Objects.requireNonNull(postRepo);
        return postRepo.findAll();
    }

    public Post findPostById(long id) {
        return postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post Not Found"));
    }

    public String addPost(long userId, Post post) {
        var optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()){
            Post newPost = new Post();
            newPost.setPostId(post.getPostId());
            newPost.setComments(new ArrayList<>());
            newPost.setBody(post.getBody());
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());
            newPost.setType(post.getType());
            newPost.setUserId(userId);

            postRepo.save(newPost);

            return "Post Created Sucessfully";
        } else {
            return "Post Failed";
        }
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public List<Post> getAllPostsByUserId(long userId) {
        return postRepo.findAllByUserId(userId);
    }

    public List<Comment> getCommentByPost(long postId) {
        return commentRepo.findAllByPostId(postId);
    }

    public Comment addCommentInPost(long postId, Comment comment) {
        var optionalPost = postRepo.findById(postId);
        Comment newComment = new Comment();
        if (optionalPost.isPresent()) {
            newComment.setPostId(postId);
            newComment.setCommentId(comment.getCommentId());
            newComment.setCommentBody(comment.getCommentBody());
            newComment.setUserId(comment.getUserId());
            return commentRepo.save(newComment);
        } else {
            throw new RuntimeException("Post Not found");
        }
    }


    public User updateUser(long userId, User user) {
        var optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User newUser = new User();
            newUser.setUserId(user.getUserId());
            newUser.setCity(user.getCity());
            newUser.setCountry(user.getCountry());
            newUser.setEmail(user.getEmail());
            newUser.setDateOfBirth(user.getDateOfBirth());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setPremiumEnabled(user.isPremiumEnabled());
            newUser.setGender(user.getGender());

            return userRepo.save(newUser);
        } else {
            throw new RuntimeException("UserId does not exist");
        }
    }

    public Post deletePostByPostId(long postId) {
        var post = postRepo.findById(postId);
        Post newPost = new Post();
        if( post.isPresent()){
            newPost = post.get();
        }
        post.ifPresent(postRepo::delete);
        return newPost;
    }
}
