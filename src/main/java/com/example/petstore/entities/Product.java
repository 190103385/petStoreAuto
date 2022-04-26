package com.example.petstore.entities;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Product")
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_seq",
            sequenceName = "product_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_id_seq"
    )
    @Column(name = "product_id")
    @Getter @Setter private int product_id;

    @Column (
            name = "product_name",
            nullable = false
    )
    @NonNull @Getter @Setter private String product_name;

    @Column (
            name = "product_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NonNull @Getter @Setter private String product_description;

//    @Column (
//            name = "product_category_id",
//            nullable = false
//    )
//    private int product_category_id;

    @Column (name = "product_price")
    @NonNull @Getter @Setter private long product_price;

    @Column (name = "product_img")
    @Getter @Setter private String product_img;

//    @Column (
//            name = "product_animal_id",
//            nullable = false
//    )
//    private int product_animal_id;

    @Column (name = "product_review_no")
    @NonNull @Getter @Setter private int product_review_no;

    @Column (name = "product_sku")
    @NonNull @Getter @Setter private int product_sku;

    @Column (name = "product_discount")
    @Getter @Setter private int product_discount;

    @Column (name = "product_discount_price")
    @Getter @Setter private long product_discount_price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_animal_id", referencedColumnName = "animal_id", nullable = false)
    @Getter @Setter private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id", nullable = false)
    @Getter @Setter private Category category;

    @OneToMany(mappedBy = "product", targetEntity = Review.class, cascade = CascadeType.ALL)
    @Getter @Setter private Set<Review> reviews;

    @OneToMany(mappedBy = "product", targetEntity = OrderDetails.class, cascade = CascadeType.ALL)
    @Getter @Setter private Set<OrderDetails> orderDetails;

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price=" + product_price +
                ", product_img='" + product_img + '\'' +
                ", product_review_no=" + product_review_no +
                ", product_sku=" + product_sku +
                ", product_discount=" + product_discount +
                ", product_discount_price=" + product_discount_price +
                ", animal=" + animal +
                ", category=" + category +
                ", reviews=" + reviews +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
