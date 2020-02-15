package com.drigler.vicko.models.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Entity
@Table(name = "joke", schema = "jokes")
@DynamicUpdate
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @OneToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private final Category category;
    @NotNull
    private final String content;
    private Integer likes;
    private Integer dislikes;

    public Integer computePopularity() {

        return likes - dislikes;
    }

}
