package com.irdeto.sibongileassessment.service;

import java.util.List;

import com.irdeto.sibongileassessment.model.User;

public interface SocialMediaAnalyserService 
{
	List<User> findMostActiveUsers(int count);
}
