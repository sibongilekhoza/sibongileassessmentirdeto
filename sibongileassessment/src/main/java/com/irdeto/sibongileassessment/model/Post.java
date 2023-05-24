package com.irdeto.sibongileassessment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	 @Column(nullable = false)
	 private String content;
	 
    
	 @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Comment> comments = new ArrayList<>();
    
	 public Post(User user, String content) {
	        this.user = user;
	        this.content = content;
	    }
	 public void addComment(Comment comment) {
	        comments.add(comment);
	        comment.setPost(this);
	    }

	    public void removeComment(Comment comment) {
	        comments.remove(comment);
	        comment.setPost(null);
	    }

}
