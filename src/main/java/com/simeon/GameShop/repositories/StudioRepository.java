package com.simeon.GameShop.repositories;

import com.simeon.GameShop.models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

}
