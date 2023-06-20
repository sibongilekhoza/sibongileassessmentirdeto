package com.irdeto.sibongileassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.SocialMediaAnalyser;
import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.service.PostService;
import com.irdeto.sibongileassessment.service.UserService;

@RestController
@RequestMapping("/social-media-analyser")
public class SocialMediaAnalyserController
{
	

	
	private  SocialMediaAnalyser socialMediaAnalyser;



    @GetMapping("/most-active-user")
    public User getMostActiveUser() {
        return socialMediaAnalyser.findMostActiveUser();
    }

    @GetMapping("/least-active-user")
    public User getLeastActiveUser() {
        return socialMediaAnalyser.findLeastActiveUser();
    }

    @GetMapping("/most-liked-post")
    public Post getMostLikedPost() {
        return socialMediaAnalyser.findMostLikedPost();
    }

    @GetMapping("/most-commented-post")
    public Post getMostCommentedPost() {
        return socialMediaAnalyser.findMostCommentedPost();
    }

    @GetMapping("/most-engaging-user")
    public User getMostEngagingUser() {
        return socialMediaAnalyser.findMostEngagingUser();
    }

}
