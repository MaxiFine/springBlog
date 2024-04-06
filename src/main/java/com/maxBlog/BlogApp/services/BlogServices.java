package com.maxBlog.BlogApp.services;

import com.maxBlog.BlogApp.entities.BlogEntity;
import com.maxBlog.BlogApp.repositories.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServices {

    private final BlogRepository blogRepository;

    public BlogServices(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    // Service to create a blog
    public BlogEntity createBlog(BlogEntity blogEntity){
        return blogRepository.save(blogEntity);
    }
    // Service to get a Blog entity
    public Optional<BlogEntity> getBlog(@PathVariable String id){
        return blogRepository.findById(id);
    }

    // Service for find all Blogs
    public List<BlogEntity> getAllBlogs(){
        return blogRepository.findAll();
    }
    // Service to Update a Blog Entity
    public Optional<BlogEntity> updateBlog(@PathVariable String id, @RequestBody BlogEntity blog) {
        Optional<BlogEntity> blogExist = blogRepository.findById(id);
        // get and change attributes if ID exits else throw null
        if (blogExist.isPresent()) {
            // set found optional object to process
            BlogEntity blogObj = blogExist.get();
            blogObj.setTitle(blog.getTitle());
            blogObj.setText(blog.getText());
            blogObj.setAuthor(blog.getAuthor());
            return Optional.of(blogRepository.save(blogObj));
        }else{
            return Optional.empty();
        }

    }
    // Service to delete blogs
    public Optional<String> deleteBlog(@PathVariable String id) {
        Optional<BlogEntity> delBlog = blogRepository.findById(id);
        if (delBlog.isPresent()) {
            blogRepository.deleteById(id);
            return Optional.of("Blog deleted Successfully...");
        } else {
            return Optional.empty();
        }
    }

}
