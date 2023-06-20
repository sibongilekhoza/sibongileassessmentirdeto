package com.irdeto.sibongileassessment.serviceimpl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irdeto.sibongileassessment.model.Hashtag;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.repositories.HashtagRepo;
import com.irdeto.sibongileassessment.repositories.PostRepo;
import com.irdeto.sibongileassessment.service.HashTagService;

@Service
public class HashtagServiceImpl implements HashTagService{
	
	   private final PostRepo postRepo;
	    private final HashtagRepo hashtagRepo;

	    @Autowired
	    public HashtagServiceImpl(PostRepo postRepo, HashtagRepo hashtagRepo) {
	        this.postRepo = postRepo;
	        this.hashtagRepo = hashtagRepo;
	    }

   
	
	@Transactional
	@Override
	public Post createPostHashtag(String content, Set<String> hashtags) {
		Post post = new Post(content);
        for (String hashtagName : hashtags) {
            Hashtag existingHashtag = hashtagRepo.findByTag(hashtagName);
            if (existingHashtag == null) {
                existingHashtag = new Hashtag(hashtagName);
                hashtagRepo.save(existingHashtag);
            }
            post.addHashtag(existingHashtag);
        }
        return postRepo.save(post);
	}

	
	@Transactional
	@Override
	public void addHashtagsToPost(Long postId, Set<String> hashtags) {
		Post post = postRepo.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        for (String hashtagName : hashtags) {
            Hashtag existingHashtag = hashtagRepo.findByTag(hashtagName);
            if (existingHashtag == null) {
                existingHashtag = new Hashtag(hashtagName);
                hashtagRepo.save(existingHashtag);
            }
            post.addHashtag(existingHashtag);
        }
        postRepo.save(post);
		
	}

	@Override
	public Hashtag createHashtag(String tag) {
		Hashtag hashtag = new Hashtag(tag);
        return hashtagRepo.save(hashtag);
	}

	@Override
	public Hashtag getHashtagById(Long id) {

		return hashtagRepo.findById(id).orElse(null);
	}

	@Override
	public List<Hashtag> getAllHashtags() {
		return hashtagRepo.findAll();
	}

	@Override
	public void deleteHashtagById(Long id) {
		hashtagRepo.deleteById(id);
		
	}

}
