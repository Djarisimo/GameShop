package com.simeon.GameShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simeon.GameShop.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
