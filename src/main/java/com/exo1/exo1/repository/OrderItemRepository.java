package com.exo1.exo1.repository;

import com.exo1.exo1.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire, par exemple :
    // List<OrderItem> findByOrderId(Long orderId);
}
