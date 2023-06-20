package com.irdeto.sibongileassessment.service;

import java.util.List;
import java.util.Set;

import com.irdeto.sibongileassessment.model.Hashtag;
import com.irdeto.sibongileassessment.model.Post;

public interface HashTagService
{

	Post createPostHashtag(String content, Set<String> hashtags);
	void addHashtagsToPost(Long postId, Set<String> hashtags);
	Hashtag createHashtag(String tag);
    Hashtag getHashtagById(Long id);
    List<Hashtag> getAllHashtags();
    void deleteHashtagById(Long id);
}
