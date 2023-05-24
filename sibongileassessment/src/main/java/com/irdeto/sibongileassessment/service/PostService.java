package com.irdeto.sibongileassessment.service;

import java.util.List;

import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;


public interface PostService 
{

	
	Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Post post);
    void deletePost(Long id);
    int getTotalPosts();
    int getPostsByUser(User user);
	
}
