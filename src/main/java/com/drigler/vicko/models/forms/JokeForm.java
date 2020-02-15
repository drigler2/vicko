package com.drigler.vicko.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.drigler.vicko.models.jokes.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JokeForm {

    @NotNull
    private Category category;
    @NotNull
    @Size(min = 2, max = 500)
    private String content;
    private final Integer likes = 0;
    private final Integer dislikes = 0;

}
