package com.irdeto.sibongileassessment.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SocialMediaAnalyser 

{
	 private List<User> users;
	 private List<Post> posts;
	 private List<Comment> comments;
	 
	 
	 public SocialMediaAnalyser() {
	        users = new ArrayList<>();
	        posts = new ArrayList<>();
	        comments = new ArrayList<>();
	        
	 }
	    
	    
	 public void addUser(User user) {
	        users.add(user);
	    }
	    
	    public void removeUser(User user) {
	        users.remove(user);
	    }
	    
	    public List<User> getUsers() {
	        return users;
	    }
	    
	    public void createPost(User user, String content) {
	        Post post = new Post(user, content);
	        posts.add(post);
	    }
	    
	    public void removePost(Post post) {
	        posts.remove(post);
	    }
	    
	    public List<Post> getPosts() {
	        return posts;
	    }
	    
	    
	 //  Get the total number of users
	    public int getTotalUsers() {
	        return users.size();
	    }
	    
	    //  Get the total number of posts
	    public int getTotalPosts() {
	        return posts.size();
	    }
	    
	    //  Get the average number of posts per user
	    public double getAveragePostsPerUser() {
	        if (users.isEmpty()) {
	            return 0;
	        }
	        
	        return (double) posts.size() / users.size();
	    }

	    
	    
	    // Display user infor
	    public void displayUserInformation() {
	        for (User user : users) {
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Username: " + user.getUsername());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("----------------------------------");
	        }
	    }
	    
	    
	 // Display post infor
	    public void displayPostInformation() {
	        for (Post post : posts) {
	            System.out.println("Post ID: " + post.getId());
	            System.out.println("Content: " + post.getContent());
	            System.out.println("Author: " + post.getUser().getUsername());
	            System.out.println("----------------------------------");
	        }
	    }
	    
	    
	    public List<User> findMostActiveUsers(int count) {
	        return users.stream()
	                .sorted(Comparator.comparingInt(user -> getUserActivity(user)))
	                .limit(count)
	                .collect(Collectors.toList());
	    }

	    private int getUserActivity(User user) {
	        int postCount = (int) posts.stream()
	                .filter(post -> post.getUser().equals(user))
	                .count();

	        int commentCount = (int) comments.stream()
	                .filter(comment -> comment.getUser().equals(user))
	                .count();

	        return postCount + commentCount;
	    }
	    

}
