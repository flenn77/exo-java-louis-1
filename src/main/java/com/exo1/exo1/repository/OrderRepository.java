package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire, par exemple :
    // List<Order> findByUserId(Long userId);
}
