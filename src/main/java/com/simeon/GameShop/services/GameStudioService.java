package com.simeon.GameShop.services;

import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.GameStudio;
import com.simeon.GameShop.repositories.GameStudioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GameStudioService {
	
	@Autowired
	private GameStudioRepository gameStudioRepository;
	
	// Return all gamestudios
	public List<GameStudio> getStudios(){
		return gameStudioRepository.findAll();
	}
	
	// Save studio
	public void save(GameStudio studio) {
		gameStudioRepository.save(studio);
	}
	
	// Delete studio
	public void deleteStudio(int id) {
		gameStudioRepository.deleteById(id);
	}
	
}
