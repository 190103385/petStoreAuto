package com.example.petstore.entities;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Animal")
@Table(name = "animal")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Animal {
    @Id
    @SequenceGenerator(
            name = "animal_id_seq",
            sequenceName = "animal_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "animal_id_seq"
    )
    @Column(name = "animal_id")
    @Getter @Setter private int animal_id;

    @Column(
            name = "animal_name",
            nullable = false,
            unique = true
    )
    @NonNull @Getter @Setter private String animal_name;

    @OneToMany(mappedBy = "animal", targetEntity = Product.class, cascade = CascadeType.ALL)
    private Set<Product> products;
}
