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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
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
    private Category category;

    @NotNull
    private String content;

    private Integer likes;
    private Integer dislikes;

    /**
     * handles null errors from db silently. TODO: this should be handled somewhere
     * else
     **/
    public Integer computePopularity() {

        if (likes == null || dislikes == null) {
            return 0;
        }

        return likes - dislikes;
    }

}
