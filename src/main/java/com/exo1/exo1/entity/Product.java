package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data // Lombok : génère automatiquement les getters, setters, equals, hashCode, et toString
@NoArgsConstructor // Lombok : génère un constructeur sans arguments
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    // La méthode calculée pour `total`, qui retourne simplement le prix.
    public BigDecimal getTotal() {
        return price;
    }
}
