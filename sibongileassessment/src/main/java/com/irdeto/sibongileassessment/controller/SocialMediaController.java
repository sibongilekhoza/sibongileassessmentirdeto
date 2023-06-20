package com.irdeto.sibongileassessment.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.irdeto.sibongileassessment.model.Comment;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.service.CommentService;
import com.irdeto.sibongileassessment.service.PostService;
import com.irdeto.sibongileassessment.service.UserService;

@Controller
@RequestMapping("/api/social-media")
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
    
    @GetMapping("/userlogin")
    public String showLoginForm() {
        return "userlogin";
    }
    
    @PostMapping("/userlogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        
        if (username.equals("admin") && password.equals("password")) {
            return "redirect:/post";
        }

        
        model.addAttribute("error", "Invalid username or password");
        return "userlogin";
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
        return "redirect:/social-media/userlogin";
    }
    
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("totalUsers", userService.getTotalUsers());
        return "users";
    }
    
    

    
    @PostMapping("/post/create")
    public String createPost(Post post) {
        postService.createPost(post);
        return "redirect:/social-media/postform";
    }
    
    @GetMapping("/post")
    public String getPosts(Model model) {
        model.addAttribute("postList", postService.getAllPosts());
        model.addAttribute("totalPosts", postService.getTotalPosts());
        return "redirect:/social-media/posts";
    }
    
    @GetMapping("/post/{postId}")
    public String viewPost(@PathVariable long postId, Model model) {
        Post post = postService.getPostById(postId);
        int likesCount = postService.getLikesCount(postId);

        model.addAttribute("thepost", post);
        model.addAttribute("likesCount", likesCount);

        return "post";
    }
    
    @DeleteMapping("/deletepost")
    public void deletePost(Long postId)
    {
    	postService.deletePost(postId);
    	
    }
    
    
    @PostMapping("/post/{postId}/comments/create")
    public String createComment(@PathVariable Long postId, Comment comment) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        commentService.createComment(comment);
        return "redirect:/social-media/posts/" + postId + "/comments";
    }
    
    
    @GetMapping("/post/{postId}/comments")
    public String getComments(@PathVariable Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getCommentsByPost(post));
        return "comments";
    }
    
    @PostMapping("/like/{postId}")
    public String likePost(@PathVariable Long postId) {
        postService.likePost(postId);
        return "redirect:/post/{postId}";
    }

    @PostMapping("/unlike/{postId}")
    public String unlikePost(@PathVariable Long postId) {
        postService.unlikePost(postId);
        return "redirect:/post/{postId}";
    }

}
