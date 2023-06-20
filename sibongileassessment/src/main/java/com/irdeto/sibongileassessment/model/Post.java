package com.irdeto.sibongileassessment.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	 
	 private int likes;
	 
	 
	 
	 private LocalDateTime date;
	 
    
	 @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Comment> comments = new ArrayList<>();
	 
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "post_hashtag",
	        joinColumns = @JoinColumn(name = "post_id"),
	        inverseJoinColumns = @JoinColumn(name = "hashtag_id")
	    )
	 private Set<Hashtag> hashtags = new HashSet<>();
    
	 
	 
	 public Post(String content) {
			
			this.content = content;
		}
	 public Post(User user, String content) {
	        this.user = user;
	        this.content = content;
	    }
	 
	 
	 public Post(User user, String content, int likes, LocalDateTime date) {
			super();
			this.user = user;
			this.content = content;
			this.likes = likes;
			this.date = date;
		}
	 
	
	 
	 public void addComment(Comment comment) {
	        comments.add(comment);
	        comment.setPost(this);
	    }

	    public void removeComment(Comment comment) {
	        comments.remove(comment);
	        comment.setPost(null);
	    }
	    
	    public void addLike() {
	        likes++;
	    }

	    public void removeLike() {
	        if (likes > 0) {
	            likes--;
	        }
	    }


	    public void setContent(String content) {
	        this.content = content;
	    }

	    public Set<Hashtag> getHashtags() {
	        return hashtags;
	    }

	    public void setHashtags(Set<Hashtag> hashtags) {
	        this.hashtags = hashtags;
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Post post = (Post) o;
	        return Objects.equals(id, post.id) &&
	                Objects.equals(content, post.content);
	    }
	    
	    
	    public void addHashtag(Hashtag hashtag) {
	        hashtags.add(hashtag);
	        hashtag.getPosts().add(this);
	    }

	    public void removeHashtag(Hashtag hashtag) {
	        hashtags.remove(hashtag);
	        hashtag.getPosts().remove(this);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, content);
	    }


		

}
