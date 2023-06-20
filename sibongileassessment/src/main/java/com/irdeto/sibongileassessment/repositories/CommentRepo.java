package com.irdeto.sibongileassessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irdeto.sibongileassessment.model.Comment;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;



public interface CommentRepo extends JpaRepository<Comment, Long>
{
	 List<Comment> findByPost(Post post);
	int countByUser(User user);
}
