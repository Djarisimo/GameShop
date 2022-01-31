package com.simeon.GameShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simeon.GameShop.models.GameStudio;

@Repository
public interface GameStudioRepository extends JpaRepository<GameStudio, Integer> {

}
