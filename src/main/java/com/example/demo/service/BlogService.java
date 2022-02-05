package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    Blog findBlog(Integer id);
    String addNewBlog(BlogDTO blog);
    String updateBlog(BlogDTO blog);
    String deleteBlog(Integer id);
    String deleteAllBlog();
}

