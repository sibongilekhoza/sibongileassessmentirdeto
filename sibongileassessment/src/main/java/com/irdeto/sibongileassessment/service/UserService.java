package com.irdeto.sibongileassessment.service;

import java.util.List;

import com.irdeto.sibongileassessment.model.User;

public interface UserService 
{
	
	 User createUser(User user);
	    User getUserById(Long id);
	    List<User> getAllUsers();
	    User updateUser(User user);
	    void deleteUser(Long id);
	    int getTotalUsers();

}
