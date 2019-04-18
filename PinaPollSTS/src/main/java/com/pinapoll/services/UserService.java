package com.pinapoll.services;

import com.pinapoll.models.User;

public interface UserService {
	public User findUserByName(String email);
	public void saveUser(User user);
	public Iterable<User> findAll();
}
