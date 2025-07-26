package com.example.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BlogRequest {
    @Getter
    @Setter
    @NotBlank(message = "Title is required.")
    private String title;

    @Getter
    @Setter
    @NotBlank(message = "Content is required.")
    private String content;

    @Getter
    @Setter
    @NotBlank(message = "Is published is required.")
    private Boolean is_published;
}
