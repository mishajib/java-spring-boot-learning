package com.example.blog.service;

import com.example.blog.dto.BlogRequest;
import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> getAllBlogs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogRepository.findAll(pageable);
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog createBlog(BlogRequest request) {
        Blog blog = new Blog();
        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        blog.setIsPublished(request.getIs_published());
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, BlogRequest request) {
        Blog existingBlog = blogRepository.findById(id).orElse(null);
        if (existingBlog == null) {
            return null;
        }

        existingBlog.setTitle(request.getTitle());
        existingBlog.setContent(request.getContent());
        existingBlog.setIsPublished(request.getIs_published());
        return blogRepository.save(existingBlog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
