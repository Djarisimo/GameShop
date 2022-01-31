package com.simeon.GameShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simeon.GameShop.models.Game;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
@Query(value = "select * from Game s where s.name like %:keyword% or s.price like %:keyword% or s.id like %:keyword%", nativeQuery = true)
 List<Game> findByKeyword(@Param("keyword") String keyword);

}
