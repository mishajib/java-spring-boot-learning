package com.example.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "The isPublished is required.")
    @Column(nullable = false)
    private Boolean isPublished;
}
