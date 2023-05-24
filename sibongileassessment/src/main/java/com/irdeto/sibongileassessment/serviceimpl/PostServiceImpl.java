package com.irdeto.sibongileassessment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.repositories.PostRepo;
import com.irdeto.sibongileassessment.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements PostService
{
	
	private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }
    
    @Override
    public Post updatePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void deletePost(Long id) {
    	postRepo.deleteById(id);
    }

    @Override
    public int getTotalPosts() {
        return postRepo.findAll().size();
    }

	@Override
	public int getPostsByUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
