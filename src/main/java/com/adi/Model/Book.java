package com.adi.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[a-zA-Z]+(\\s+[a-zA-Z]+)*",message = "invalid title name")
    private String title;

    @NonNull
    @Column
    @Size(min = 3)
    @Pattern(regexp = "[a-zA-Z]+(\\s+[a-zA-Z]+)*",message = "invalid autor name")
    private String author;



//    @NonNull
//    @Column
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private Date readDate;




}
