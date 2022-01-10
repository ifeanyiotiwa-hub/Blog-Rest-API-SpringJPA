package dev.gxsoft.blogrestjpa.controller;


import dev.gxsoft.blogrestjpa.model.Comment;
import dev.gxsoft.blogrestjpa.model.Post;
import dev.gxsoft.blogrestjpa.model.User;
import dev.gxsoft.blogrestjpa.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/api")
public class BlogController {

    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        logger.info("getAllPosts method is triggered");
        var posts = blogService.findAllPost();
        logger.info(String.valueOf(posts));
        return posts;
    }

    @GetMapping("posts/{id}")
    public Post getPostById(@PathVariable long id) {
        logger.info("getPostById method is triggered");
        var post = blogService.findPostById(id);
        logger.info(String.valueOf(post));
        return post;
    }

    @GetMapping("posts/users/{userId}")
    public List<Post> getAllPostByUserId(@PathVariable long userId) {
        logger.info("Calling getAllPostByUserId");
        var posts = blogService.getAllPostsByUserId(userId);
        logger.info(posts.toString());
        return posts;
    }

    @PostMapping("/addUser")
    public String register(@RequestBody User user) {
        logger.info(user.toString());
        blogService.saveUser(user);
        return "User Saved";
    }

    @PostMapping("/addPost/{userId}")
    public String addPost(@PathVariable long userId, @RequestBody Post post) {
        return blogService.addPost(userId, post);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable long postId) {
        return blogService.getCommentByPost(postId);
    }

    @PostMapping("/posts/{postId}/comment")
    public Comment addComment(@PathVariable int postId, @RequestBody Comment comment) {
        return blogService.addCommentInPost(postId, comment);
    }

    @PutMapping("/users/user/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User user) {
        return blogService.updateUser(userId, user);
    }

    @DeleteMapping("/posts/{postId}")
    public Post deletePost(@PathVariable long postId) {
        return blogService.deletePostByPostId(postId);
    }
}
