package com.example.petstore.entities;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_id_seq",
            sequenceName = "review_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "review_id_seq"
    )
    @Column(name = "review_id")
    private int review_id;

//    @Column(
//            name = "review_product_id",
//            nullable = false
//    )
//    private int review_product_id;

    @Column(
            name = "review_title"
    )
    private String review_title;

    @Column(
            name = "review_body",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String review_body;

    @Column(
            name = "review_rating",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private int review_rating;

//    @Column(
//            name = "review_user_id",
//            nullable = false,
//            columnDefinition = "SMALLINT"
//    )
//    private int review_user_id;

    @Column(
            name = "review_date"
    )
    private String review_date;

    @Column(
            name = "review_is_positive"
    )
    private boolean review_is_positive;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "review_product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "review_user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
