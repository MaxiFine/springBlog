package com.maxBlog.BlogApp.repositories;

import com.maxBlog.BlogApp.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// Am interface
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, String>{
    BlogEntity findById(long id);
}

