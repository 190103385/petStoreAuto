package com.example.petstore.entities;

import lombok.*;
import javax.persistence.*;

@Entity(name = "Test")
@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Test {
    @Id
    @SequenceGenerator(name = "test_seq", sequenceName = "test_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long id;

    @Column(name = "name")
    @NonNull private String name;
}
