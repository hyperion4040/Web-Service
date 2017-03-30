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
//    @Size(min = 3, max = 30)
//    @Pattern(regexp = "^[A-Za-z]+$")
    private String title;

    @NonNull
    @Column
//    @Size(min = 2)
//    @Pattern(regexp = "^[A-Za-z]+$")
    private String author;




}
