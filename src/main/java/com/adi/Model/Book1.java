package com.adi.Model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by hyperion on 09.03.17.
 * Remember setters and getters
 */

@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Book1 {

    @NonNull
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String title;

    @NonNull
    @NotNull
    @Size(min = 2)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String author;


}
