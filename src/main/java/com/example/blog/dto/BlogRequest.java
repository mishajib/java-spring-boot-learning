package com.example.blog.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class BlogRequest {
    @Valid

    @Getter
    @Setter
    @NotBlank(message = "The title is required.")
    @NotNull(message = "The title is required.")
    private String title;

    @Getter
    @Setter
    @NotEmpty(message = "The content is required.")
    @NotNull(message = "The title is required.")
    private String content;

    @Getter
    @Setter
    @NotNull(message = "The is published is required.")
    @NotNull(message = "The title is required.")
    private Boolean is_published;

}
