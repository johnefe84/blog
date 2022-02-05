package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.dto.BlogDTO;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findBlog(Integer id) {
        Optional user = blogRepository.findById(id);

        if(user.isPresent()){
            return (Blog) user.get();
        }
        else{
            return null;
        }
    }

    @Override
    public String addNewBlog(BlogDTO blogDTO) {
        Blog newBlog = new Blog();
        newBlog.setTimestamp(new Timestamp(new Date().getTime()));
        newBlog.setTitle(blogDTO.getTitle());
        newBlog.setText(blogDTO.getText());
        newBlog.setCategory(blogDTO.getCategoryId());
        blogRepository.save(newBlog);
        return "Blog Saved";
    }

    @Override
    public String updateBlog(BlogDTO blogDTO) {
        Optional blog = blogRepository.findById(blogDTO.getId());
        Blog updateBlog = (Blog) blog.get();
        updateBlog.setTitle(blogDTO.getTitle());
        updateBlog.setText(blogDTO.getText());
        updateBlog.setCategory(blogDTO.getCategoryId());
        blogRepository.save(updateBlog);
        return "updated";
    }

    @Override
    public String deleteBlog(Integer id) {
        Optional user = blogRepository.findById(id);

        if (user.isPresent()) {
            blogRepository.delete((Blog) user.get());
            return "updated";
        }
        else{
            return "user not found";
        }
    }

    @Override
    public String deleteAllBlog() {
        blogRepository.deleteAll();
        return "all records have been deleted";
    }
}
