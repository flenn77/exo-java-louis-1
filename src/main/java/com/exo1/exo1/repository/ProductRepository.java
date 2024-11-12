package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire, par exemple :
    // List<Product> findByCategory(String category);
}
