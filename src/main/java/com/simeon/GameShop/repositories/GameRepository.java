package com.simeon.GameShop.repositories;

import com.simeon.GameShop.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query(value = "SELECT * FROM Game g WHERE g.name LIKE %:keyword% or g.price LIKE %:keyword%", nativeQuery = true)
    List<Game> findByNameOrPriceLike(@Param("keyword") String keyword);
}
