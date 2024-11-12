package com.exo1.exo1.repository;

import com.exo1.exo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire, par exemple :
    // Optional<User> findByEmail(String email);
}
