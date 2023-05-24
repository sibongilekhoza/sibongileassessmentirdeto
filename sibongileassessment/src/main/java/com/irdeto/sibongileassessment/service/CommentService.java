package com.irdeto.sibongileassessment.service;

import java.util.List;

import com.irdeto.sibongileassessment.model.Comment;
import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;

public interface CommentService 
{
	
	 Comment createComment(Comment comment);
	    Comment getCommentById(Long id);
	    List<Comment> getCommentsByPost(Post post);
	    List<Comment> getAllComments();
	    Comment updateComment(Comment comment);
	    void deleteComment(Long id);
	    int getCommentsByUser(User user);

}
