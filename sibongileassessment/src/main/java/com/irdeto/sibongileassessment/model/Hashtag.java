package com.irdeto.sibongileassessment.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



@Accessors(chain = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "hashtag")
public class Hashtag {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag")
    private String tag;

    @ManyToMany(mappedBy = "hashtags")
    private Set<Post> posts = new HashSet<>();

    // Constructors, getters, and setters

    public Hashtag() {
    }

    public Hashtag(String tag) {
        this.tag = tag;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

  
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) &&
                Objects.equals(tag, hashtag.tag);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, tag);
    }
}

