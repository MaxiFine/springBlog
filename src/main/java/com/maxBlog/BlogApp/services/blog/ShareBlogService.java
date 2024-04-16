package com.maxBlog.BlogApp.services.blog;

import com.maxBlog.BlogApp.entities.BlogEntity;
import com.maxBlog.BlogApp.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class ShareBlogService {

    private final JavaMailSender emailSender;
    private final BlogRepository blogRepository;

    @Autowired
    public ShareBlogService(JavaMailSender javaMailSender, BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        this.emailSender = javaMailSender;
    }


    public void shareBlog(String to, String subject, String text, long id) throws MailException {
        BlogEntity blog = blogRepository.findById(id);
        text = "Hello, \n\n" + "We thought you might be interested in this blog: \n" + "http://localhost:8088/blogs/" + blog.getId() + "\n\n" + "Best regards, \n" + "Your Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(message.getFrom());
        message.setTo(to);
        message.setSubject(subject + blog.getTitle());
        message.setText(text);
        emailSender.send(message);
    }

    public void shareBlog(String to, String subject, String text) throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(message.getFrom());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }


}
