package com.simeon.GameShop.repositories;

import com.simeon.GameShop.models.Cart;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByGameId (int gameId);
}
