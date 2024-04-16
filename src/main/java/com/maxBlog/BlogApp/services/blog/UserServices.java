package com.maxBlog.BlogApp.services.blog;

import com.maxBlog.BlogApp.entities.User;
import com.maxBlog.BlogApp.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository userRepository;

  public UserServices(UserRepository userRepository){
      this.userRepository = userRepository;
  }

  public List<User> getAllUsers(){
      return userRepository.findAll();
  }

  public Optional<User> getUser(String id){
      return userRepository.findById(id);
  }
}
