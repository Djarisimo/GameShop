package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    public Page<Game> findPaginated(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return gameRepository.findAll(pageable);
    }

    public void addEditGame(Game game) {
        gameRepository.save(game);
    }
    
    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findByNameOrPriceLike(String keyword) {
        return gameRepository.findByNameOrPriceLike(keyword);
    }
    
    public Game getGameById(int id) {
        return gameRepository.findById(id).get();
    }
    
//    public List<Game> getAllGames() {
//        return gameRepository.findAll();
//    }
    

//    public void updateGame(int id, Game game) {
//        Optional<Game> optionalGame = gameRepository.findById(id);
//        if (optionalGame.isPresent()) {
//            Game foundGame = optionalGame.get();
//            if (game.getName() != null) {
//                foundGame.setName(game.getName());
//            }
//            if (game.getPrice() != null) {
//                foundGame.setPrice(game.getPrice());
//            }
//            if (game.getPictureUrl() != null) {
//                foundGame.setPictureUrl(game.getPictureUrl());
//            }
//            if (game.getStudio() != null) {
//                foundGame.setStudio(game.getStudio());
//            }
//            if (game.getGenre() != null) {
//                foundGame.setGenre(game.getGenre());
//            }
//            if (game.getPlatform() != null) {
//                foundGame.setPlatform(game.getPlatform());
//            }
//            gameRepository.save(foundGame);
//        }
//    }  
}
