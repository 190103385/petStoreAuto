package com.example.petstore.entities;

import lombok.Data;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "AppOrder")
@Table(name = "app_order")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id_seq",
            sequenceName = "order_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_id_seq"
    )
    @Column(name = "order_id")
    private int order_id;

//    @Column(
//            name = "order_user_id",
//            nullable = false
//    )
//    private int order_user_id;

    @Column(
            name = "order_date",
            nullable = false
    )
    private String order_date;

    @Column(
            name = "order_amount",
            nullable = false
    )
    private int order_amount;

    @Column(
            name = "order_status",
            nullable = false
    )
    private boolean order_is_delivered = false;

    @OneToMany(mappedBy = "order", targetEntity = OrderDetails.class, cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
