package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findById(long id);
	User deleteById(long id);
	User findByuserid(long userid);
}
