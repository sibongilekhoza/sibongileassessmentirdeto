package com.irdeto.sibongileassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irdeto.sibongileassessment.model.Hashtag;
import com.irdeto.sibongileassessment.service.HashTagService;

@RestController
@RequestMapping("/hashtags")
public class HashtagController 
{
	
	private final HashTagService hashtagService;

    @Autowired
    public HashtagController(HashTagService hashtagService) {
        this.hashtagService = hashtagService;
    }
    
    
    @GetMapping("/create")
    public String showCreateHashtagForm() {
        return "hashtag";
    }

    @PostMapping("/create")
    public String createHashtag(@RequestParam("name") String name) {
        hashtagService.createHashtag(name);
        return "redirect:/hashtags";
    }

    @GetMapping("/{id}")
    public String getHashtagById(@PathVariable("id") Long id, Model model) {
        Hashtag hashtag = hashtagService.getHashtagById(id);
        model.addAttribute("hashtag", hashtag);
        return "hashtag";
    }
    
    @GetMapping
    public String getAllHashtags(Model model) {
        List<Hashtag> hashtags = hashtagService.getAllHashtags();
        model.addAttribute("hashtags", hashtags);
        return "hashtags";
    }

    @PostMapping("/{id}/delete")
    public String deleteHashtag(@PathVariable("id") Long id) {
        hashtagService.deleteHashtagById(id);
        return "redirect:/hashtags";
    }

}
