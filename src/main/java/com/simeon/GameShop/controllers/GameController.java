package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.GameService;
import com.simeon.GameShop.services.GenreService;
import com.simeon.GameShop.services.PlatformService;
import com.simeon.GameShop.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;


    @GetMapping("games")
    public String getAllGames(Model model, String keyword) {

        model.addAttribute("studios", studioService.getAllStudios());
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("platforms", platformService.getAllPlatforms());

        if (keyword != null) {
            model.addAttribute("games", gameService.findByKeyword(keyword));
        } else {
            model.addAttribute("games", gameService.getAllGames());
        }
        
        return "games";
    }

    @PostMapping("games")
    public String addGame(Game game) {
        gameService.addEditGame(game);
        return "redirect:/games";
    }

//    @PostMapping("games/{id}")
//    public String updateGame(@PathParam("id") int id, Game game) {
//        gameService.updateGame(id, game);
//        return "redirect:/games";
//
//    }
    
    @PostMapping("/games/edit")
    public String editGame(Game game) {
        gameService.addEditGame(game);
        return "redirect:/games";
    }

//    @PostMapping("games/{id}/delete")
//    public String deleteGame(@PathParam("id") int id) {
//        gameService.deleteGame(id);
//        return "redirect:/games";
//    }
        
    @GetMapping("/games/delete")
    public String deleteGame(@RequestParam(name = "id") int id) {
        gameService.deleteGame(id);
        return "redirect:/games";
    }
}
