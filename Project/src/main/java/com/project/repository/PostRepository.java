package com.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
	List<Post> findAll();
	
}
