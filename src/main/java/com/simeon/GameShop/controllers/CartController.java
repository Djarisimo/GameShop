package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("cart-items")
    public String getAllCartItems(Model model) {

        model.addAttribute("shoppingCart", cartItemService.getAllCartItems());

        return "shoppingCart";
    }

    @PostMapping("cart-items")
    public String addGameToCartItems(Game game) {     
        cartItemService.addGameToCart(game);
        return "redirect:/cart-items";
    }

//    @PostMapping("/cart-items/games/{gameId}/delete")
//    public String removeGameFromCartItems(@PathParam("gameId") int gameId) {
//        cartItemService.removeGameFromCart(gameId);
//        return "redirect:/shoppingCart";
//    }
    
    @GetMapping("/cart-items/delete")
    public String deleteGameFromCart(@RequestParam(name = "id") int id) {
        cartItemService.deleteGameFromCart(id);
        return "redirect:/cart-items";
    }
}
