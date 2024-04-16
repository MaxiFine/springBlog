package com.maxBlog.BlogApp.controllers.blog;

import com.maxBlog.BlogApp.entities.User;
import com.maxBlog.BlogApp.services.blog.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/tester")
public class AuthDemoController {

    private final UserServices userServices;

    public AuthDemoController(UserServices userServices){
        this.userServices = userServices;
    }


    @GetMapping("/test-demo")
    public ResponseEntity<String> sayHello(String hello){

        return ResponseEntity.ok("Hello, endpoint now hit...");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        Optional<User> user = userServices.getUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.valueOf("User not Found, Create user instead."));
        }
    }
}
