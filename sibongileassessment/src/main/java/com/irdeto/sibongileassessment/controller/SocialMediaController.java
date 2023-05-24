package com.irdeto.sibongileassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.irdeto.sibongileassessment.model.Comment;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.service.CommentService;
import com.irdeto.sibongileassessment.service.PostService;
import com.irdeto.sibongileassessment.service.UserService;

@Controller
@RequestMapping("/social-media")
public class SocialMediaController
{
	
	private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public SocialMediaController(UserService userService, PostService postService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/userform", method =RequestMethod.GET )
	public String RegistaPage(ModelMap model)

	{
		User user = new User();
		model.addAttribute("user", user);
		
			 
		return "userform";
	}
    
    @PostMapping("/create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/social-media/users";
    }
    
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("totalUsers", userService.getTotalUsers());
        return "users";
    }
    
    
    @PostMapping("/posts/create")
    public String createPost(Post post) {
        postService.createPost(post);
        return "redirect:/social-media/posts";
    }
    
    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("totalPosts", postService.getTotalPosts());
        return "posts";
    }
    
    
    @PostMapping("/posts/{postId}/comments/create")
    public String createComment(@PathVariable Long postId, Comment comment) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        commentService.createComment(comment);
        return "redirect:/social-media/posts/" + postId + "/comments";
    }
    
    
    @GetMapping("/posts/{postId}/comments")
    public String getComments(@PathVariable Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getCommentsByPost(post));
        return "comments";
    }

}
