package com.example.petstore.entities;

import lombok.Data;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "order_details")
public class OrderDetails {
    @Id
    @SequenceGenerator(
            name = "detail_id_seq",
            sequenceName = "detail_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "detail_id_seq"
    )
    @Column(name = "detail_id")
    private int detail_id;

//    @Column(
//            name = "detail_order_id",
//            nullable = false
//    )
//    private int detail_order_id;

//    @Column(
//            name = "detail_product_id",
//            nullable = false
//    )
//    private int detail_product_id;

    @Column(
            name = "detail_price",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private int detail_price;

    @Column(
            name = "detail_quantity",
            nullable = false
    )
    private int detail_quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "detail_product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "detail_order_id", referencedColumnName = "order_id", nullable = false)
    private Order order;
}
