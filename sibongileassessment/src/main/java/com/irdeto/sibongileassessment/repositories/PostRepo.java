package com.irdeto.sibongileassessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irdeto.sibongileassessment.model.Post;
import com.irdeto.sibongileassessment.model.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Long>
{
	 int countByUser(User user);
}
