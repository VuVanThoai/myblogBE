package com.thoaidz.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thoaidz.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM User WHERE username = :username AND password = :password", nativeQuery = true)
	User getUser(@Param("username") String username, @Param("password") String password);
	
	@Query(value = "SELECT * FROM User WHERE username = :username", nativeQuery = true)
	User getUserByUsername(@Param("username") String username);
	
	@Query(value = "SELECT * FROM User WHERE id = :id", nativeQuery = true)
	User findById(@Param("id") int id);
}
