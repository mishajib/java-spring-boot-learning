package com.example.blog.controller;

import com.example.blog.dto.BlogRequest;
import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public Page<Blog> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return blogService.getAllBlogs(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Blog getById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BlogRequest request) {
        Blog blog = blogService.createBlog(request);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Blog created successfully!");
        response.put("blog", blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody BlogRequest request) {
        Blog existingBlog = blogService.getBlogById(id);
        if (existingBlog == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Blog not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        Blog blog = blogService.updateBlog(id, request);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Blog updated successfully!");
        response.put("blog", blog);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Blog existingBlog = blogService.getBlogById(id);
        if (existingBlog == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Blog not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        blogService.deleteBlog(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Blog deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
