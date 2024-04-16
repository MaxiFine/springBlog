package com.maxBlog.BlogApp.controllers.blog;

import com.maxBlog.BlogApp.services.blog.ShareBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/blogs")
public class ShareBlogController {

    private final ShareBlogService shareBlogService;

    public ShareBlogController(ShareBlogService shareBlogService) {
        this.shareBlogService = shareBlogService;
    }

    @PostMapping("/share/{id}")
    public ResponseEntity<String> shareBlog (@PathVariable long id,
                                            @RequestParam String to,
                                            @RequestParam String subject,
                                            @RequestParam String text) {
        try {
            shareBlogService.shareBlog(to, subject, text, id);
            return ResponseEntity.ok("Blog shared successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
