package com.example.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BlogRequest {

    @Getter
    @Setter
    @NotBlank(message = "The title is required.")
    @Size(min = 2, max = 255, message = "The title must be between 2 and 255 characters.")
    private String title;

    @Getter
    @Setter
    @NotBlank(message = "The content is required.")
    private String content;

    @Getter
    @Setter
    @NotNull(message = "The isPublished is required.")
    private Boolean is_published;

}
