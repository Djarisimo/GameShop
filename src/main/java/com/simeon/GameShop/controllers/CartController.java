package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Cart;
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CartController {
    
    @Autowired
    private CartService cartService; 
    
    @GetMapping("/cart")
    public String getCart(Model model) {
      
        model.addAttribute("shoppingCart", cartService.getCart());

        return "shoppingCart";
    }

    @PostMapping("/cart/games")
    public String addToCart(Game game) {
        cartService.save(game);
        return "redirect:/shoppingCart";
    }
    
    @DeleteMapping("/cart/games/{id}")
    public String deleteFromCart(@PathParam("id") int id) {

        cartService.deleteFromCart(id);
        return "redirect:/shoppingCart";
    }
}
