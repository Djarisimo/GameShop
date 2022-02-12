package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import com.simeon.GameShop.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/details/{id}")
    public String Details(@PathVariable("id") int id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("games", game);
        
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);
        return "details";
    }
}
