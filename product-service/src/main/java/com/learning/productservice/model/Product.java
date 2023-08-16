package com.learning.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "Product")
@Table(
        name = "product",
        uniqueConstraints = {
            @UniqueConstraint(name = "unique_product_name", columnNames = "name")
        }
)
public class Product {

    @Id
    @SequenceGenerator(
        name = "product_sequence",
        sequenceName = "product_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = SEQUENCE, generator = "product_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
}
