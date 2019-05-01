package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.User;

public interface UserService {
	public User findUserByName(String name);
	public void saveUser(User user);
	public Iterable<User> findAll();
	public List<User> searchUserWithName(String name);
}
