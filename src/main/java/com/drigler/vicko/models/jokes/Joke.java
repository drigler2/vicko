package com.drigler.vicko.models.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "joke", schema = "jokes")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @OneToOne(targetEntity = Category.class)
    private final Category category;
    @NotNull
    private final String content;
    private Integer likes;
    private Integer dislikes;

    public Integer computePopularity() {

        return likes - dislikes;
    }

}
