package com.adi.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by hyperion on 08.03.17.
 * Weak point for now of application
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String title;

    @NotNull
    @Size(min = 2)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


}
