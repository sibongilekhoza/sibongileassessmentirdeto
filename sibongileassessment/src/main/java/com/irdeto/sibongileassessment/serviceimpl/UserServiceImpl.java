package com.irdeto.sibongileassessment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.sibongileassessment.model.User;
import com.irdeto.sibongileassessment.repositories.UserRepo;
import com.irdeto.sibongileassessment.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService
{


	
	@Autowired
	private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
    
    @Override
    public void deleteUser(Long id) {
    	userRepo.deleteById(id);
    }


	@Override
	public int getTotalUsers() {


		return userRepo.findAll().size();
	}
	
}
