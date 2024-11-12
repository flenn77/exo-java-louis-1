package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data // Lombok : génère automatiquement les getters, setters, equals, hashCode, et toString
@NoArgsConstructor // Lombok : génère un constructeur sans arguments
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal price;

    // Méthode calculée pour obtenir le total
    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    // Vous pouvez omettre le setter pour `total` si ce champ est uniquement calculé
}
