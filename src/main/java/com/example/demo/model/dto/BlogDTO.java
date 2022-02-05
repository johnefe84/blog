package com.example.demo.model.dto;

import com.example.demo.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class BlogDTO {
    private Integer id;
    private String title;
    private String text;
    private Timestamp timestamp;
    private Integer categoryId;
}
