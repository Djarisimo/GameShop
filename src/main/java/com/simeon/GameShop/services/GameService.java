package com.simeon.GameShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.repositories.GameRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	// Return all games
	public List<Game> getGames(){
		return gameRepository.findAll();
	}
	
	// Save Game
	public void save(Game game) {
		gameRepository.save(game);
	}
		
	// Delete Game
	public void deleteGame(int id) {
		gameRepository.deleteById(id);
	}      
          
	public List<Game> findByKeyword(String keyword){
                return gameRepository.findByKeyword(keyword);
        }                 
}
