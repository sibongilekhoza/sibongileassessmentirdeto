package com.irdeto.sibongileassessment.serviceimpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.service.CommentService;
import com.irdeto.sibongileassessment.service.PostService;
import com.irdeto.sibongileassessment.service.SocialMediaAnalyserService;
import com.irdeto.sibongileassessment.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SocialMediaAnalyserServiceImpl implements SocialMediaAnalyserService{

	 private final UserService userService;
	    private final PostService postService;
	    private final CommentService commentService;

	    @Autowired
	    public SocialMediaAnalyserServiceImpl(UserService userService, PostService postService, CommentService commentService) {
	        this.userService = userService;
	        this.postService = postService;
	        this.commentService = commentService;
	    }
	
	
	@Override
	public List<User> findMostActiveUsers(int count) {

		List<User> users = userService.getAllUsers();

        return users.stream()
                .sorted(Comparator.comparingInt(user -> getUserActivity(user)))
                .limit(count)
                .collect(Collectors.toList());

	}
	
	
	 private int getUserActivity(User user) {
	        int postCount = postService.getPostsByUser(user);
	        int commentCount = commentService.getCommentsByUser(user);

	        return postCount + commentCount;
	    }

}
