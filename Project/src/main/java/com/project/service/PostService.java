package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Post;
import com.project.repository.PostRepository;
import com.project.repository.UserRepository;

@Service
public class PostService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	
	@Autowired
	public void setUserRepository(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Autowired
	public void setPostRepository(PostRepository postRepo) {
		this.postRepo = postRepo;
	}

	public List<Post> getStories() {
		return postRepo.findAll();
	}
	
	
	
}
