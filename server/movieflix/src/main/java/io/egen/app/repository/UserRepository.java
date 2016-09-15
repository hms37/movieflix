package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String userId);

	public User findByEmail(String email);

	public User create(User user);

	public User update(User user);

	public void delete(User existing);
}

