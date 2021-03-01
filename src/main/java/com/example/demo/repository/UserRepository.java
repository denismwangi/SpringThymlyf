package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;




/**
 * @author 
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByEmail(String email);

}