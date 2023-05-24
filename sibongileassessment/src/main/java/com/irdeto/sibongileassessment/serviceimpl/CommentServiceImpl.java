package com.irdeto.sibongileassessment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.sibongileassessment.model.Comment;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.repositories.CommentRepo;
import com.irdeto.sibongileassessment.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService
{

	
	private final CommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
	
    @Override
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepo.findByPost(post);
    }
    
    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
    	commentRepo.deleteById(id);
    }

	@Override
	public int getCommentsByUser(User user) {
		 return commentRepo.countByUser(user);
	}

}
