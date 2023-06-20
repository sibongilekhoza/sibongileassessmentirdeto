package com.irdeto.sibongileassessment.service;

import java.util.ArrayList;
import java.util.List;

import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;


public interface PostService 
{

	
	Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Post post); 
    ArrayList<Post> deletePost(Long postId);
    int getLikesCount(Long postId);
    void likePost(Long postId);
    void unlikePost(Long postId);
    int getTotalPosts();
    int getPostsByUser(User user);
	
}
