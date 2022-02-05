package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.model.dto.BlogDTO;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private BlogService blogService;
    private CategoryService categoryService;

    public MainController(BlogService blogService, CategoryService categoryService){
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping(path="/posts")
    public @ResponseBody Iterable<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping(path="/posts/{id}")
    public @ResponseBody
    Blog findUser(@PathVariable Integer id) {
        return blogService.findBlog(id);
    }

    @GetMapping(path="/categories")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(path="/posts", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addNewUserJson(@RequestBody BlogDTO blog) {
        return blogService.addNewBlog(blog);
    }

    @PutMapping(path="/posts")
    public @ResponseBody String updateUser(@RequestBody BlogDTO blog) {
        return blogService.updateBlog(blog);
    }

    @DeleteMapping(path="/posts/{id}")
    public @ResponseBody String deleteBlog(@PathVariable Integer id) {
        return blogService.deleteBlog(id);
    }

    @DeleteMapping(path="/posts")
    public @ResponseBody String deleteAllBlog() {
        return blogService.deleteAllBlog();
    }
}
