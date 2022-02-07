package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import com.simeon.GameShop.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController {
    
    @Autowired
    private GameService gameService;

    @GetMapping("/details/{id}")
    public String getAllGames(@PathVariable("id") int id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("games", game);
        return "details";
    }
}
