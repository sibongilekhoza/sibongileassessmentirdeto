package com.irdeto.sibongileassessment.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SocialMediaAnalyser {
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
    
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    public User findMostActiveUser() {
        return users.stream()
                .max(Comparator.comparingInt(user -> getPostAndCommentCount(user)))
                .orElse(null);
    }
    
    public User findLeastActiveUser() {
        return users.stream()
                .min(Comparator.comparingInt(user -> getPostAndCommentCount(user)))
                .orElse(null);
    }
    
    public Post findMostLikedPost() {
        return posts.stream()
                .max(Comparator.comparingInt(Post::getLikes))
                .orElse(null);
    }
    
    public Post findMostCommentedPost() {
        return posts.stream()
                .max(Comparator.comparingInt(post -> post.getComments().size()))
                .orElse(null);
    }
    
    public User findMostEngagingUser() {
        Map<User, Integer> engagementMap = users.stream()
                .collect(Collectors.toMap(user -> user, this::calculateEngagement));
        
        return engagementMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    private int getPostAndCommentCount(User user) {
        int postCount = (int) posts.stream()
                .filter(post -> post.getUser().equals(user))
                .count();
        
        int commentCount = (int) comments.stream()
                .filter(comment -> comment.getUser().equals(user))
                .count();
        
        return postCount + commentCount;
    }
    
    private int calculateEngagement(User user) {
        int postCount = (int) posts.stream()
                .filter(post -> post.getUser().equals(user))
                .count();
        
        int commentCount = (int) comments.stream()
                .filter(comment -> comment.getUser().equals(user))
                .count();
        
        int likesCount = posts.stream()
                .filter(post -> post.getUser().equals(user))
                .mapToInt(Post::getLikes)
                .sum();
        
        return postCount + commentCount + likesCount;
    }
}
