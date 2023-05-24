package com.irdeto.sibongileassessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irdeto.sibongileassessment.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
