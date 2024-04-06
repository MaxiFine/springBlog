package com.maxBlog.BlogApp.repositories;

import com.maxBlog.BlogApp.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Am interface
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, String>{}

