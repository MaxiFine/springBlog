package com.maxBlog.BlogApp.controllers;

import com.maxBlog.BlogApp.entities.BlogEntity;
import com.maxBlog.BlogApp.repositories.BlogRepository;
import com.maxBlog.BlogApp.services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogServices blogServices;

//   Constructor Injection here...
    public BlogController(BlogServices blogServ){
        this.blogServices = blogServ;
    }

    // Get all Blogs Controller
    @GetMapping("/all-blogs")
    public ResponseEntity<List<BlogEntity>> listBlogs(){
        List<BlogEntity> blogs = blogServices.getAllBlogs();
        if(blogs.isEmpty())
            return new ResponseEntity<>(blogs, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Get a blog Controller
    @GetMapping("/find-blog/{id}")
    public ResponseEntity<BlogEntity> findBlog(@PathVariable String id){
        Optional<BlogEntity> blog = blogServices.getBlog(id);
        if(blog.isPresent()){
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create Mapping Controller
    @PostMapping("/create-blog")
    public ResponseEntity<BlogEntity> create(@RequestBody BlogEntity createBlog){
        BlogEntity blog = blogServices.createBlog(createBlog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    // Edit a blog Controller
    @PutMapping("/edit-blog/{id}")
    public ResponseEntity<BlogEntity> editBlog(@PathVariable String id, @RequestBody BlogEntity blogEntity){
        Optional<BlogEntity> blog = blogServices.updateBlog(id, blogEntity);
        if(blog.isPresent()){
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a blog Controller
    @DeleteMapping("/delete-blog/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        Optional<String> delBlog = blogServices.deleteBlog(id);
        if (delBlog.isPresent())
            return new ResponseEntity<>(delBlog.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

