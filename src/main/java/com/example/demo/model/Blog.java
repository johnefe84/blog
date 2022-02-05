package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;
    private String text;
    private Timestamp timestamp;

    private Integer category;

    /*@OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "category" , insertable = false, updatable = false)
    private Category category;*/
}
