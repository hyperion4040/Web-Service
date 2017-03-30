package com.adi.Model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by hyperion on 08.03.17.
 * Weak point for now of application
 */
@Entity
@Data
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String author;




}
