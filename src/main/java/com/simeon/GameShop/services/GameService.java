package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(int id, Game game) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game foundGame = optionalGame.get();
            if (game.getName() != null) {
                foundGame.setName(game.getName());
            }
            if (game.getPrice() != null) {
                foundGame.setPrice(game.getPrice());
            }
            if (game.getPictureUrl() != null) {
                foundGame.setPictureUrl(game.getPictureUrl());
            }
            if (game.getStudio() != null) {
                foundGame.setStudio(game.getStudio());
            }
            if (game.getGenre() != null) {
                foundGame.setGenre(game.getGenre());
            }
            if (game.getPlatforms() != null) {
                foundGame.setPlatforms(game.getPlatforms());
            }
            gameRepository.save(foundGame);
        }
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findByKeyword(String keyword) {
        return gameRepository.findByNameOrPriceLike(keyword);
    }
}
