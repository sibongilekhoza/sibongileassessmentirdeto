package com.irdeto.sibongileassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.service.SocialMediaAnalyserService;

@RestController
@RequestMapping("/analytics")
public class SocialMediaAnalyserController
{
	
	private final SocialMediaAnalyserService socialMediaAnalyserService;

    @Autowired
    public SocialMediaAnalyserController(SocialMediaAnalyserService socialMediaAnalyserService) {
        this.socialMediaAnalyserService = socialMediaAnalyserService;
    }

    
    @GetMapping("/mostActiveUsers")
    public List<User> getMostActiveUsers() {
        int count = 5; // Set the desired count of most active users
        return socialMediaAnalyserService.findMostActiveUsers(count);
    }
    
 
}
