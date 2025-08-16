package com.example.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;


    @NotBlank(message = "The title is required.")
    @Column(nullable = false)
    private String  title;

    @NotBlank(message = "The content is required.")
    @Column(nullable = false)
    private String  content;

    @NotNull(message = "The isPublished is required.")
    @Column(nullable = false)
    private Boolean isPublished;
}
