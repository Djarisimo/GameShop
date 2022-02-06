package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cart-items")
    public String getAllCartItems(Model model) {

        model.addAttribute("shoppingCart", cartItemService.getAllCartItems());

        return "shoppingCart";
    }

    @PostMapping("/cart-items/games")
    public String addGameToCartItems(Game game) {
        System.out.println("game" + game);
        cartItemService.addGameToCart(game);
        return "redirect:/shoppingCart";
    }

    @PostMapping("/cart-items/games/{gameId}/delete")
    public String removeGameFromCartItems(@PathParam("gameId") int gameId) {
        cartItemService.removeGameFromCart(gameId);
        return "redirect:/shoppingCart";
    }
}
