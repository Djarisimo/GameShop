package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("cart-items")
    public String getAllCartItems(Model model) {
        
        List<CartItem> list = cartItemService.getAllCartItems();
     
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < list.size(); i++) {
            totalPrice = totalPrice.add(list.get(i).getGame().getPrice().multiply(
                 
            new BigDecimal(list.get(i).getQuantity())
            ) );
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("shoppingCart", list);
        
        return "shoppingCart";
    }

    @PostMapping("cart-items")
    public String addGameToCartItems(Game game) {     
        cartItemService.addGameToCart(game);
        return "redirect:/cart-items";
    }
    
    @PostMapping("/cart-items/update")
    public String updateGameToCartItems(@RequestParam("quantity") int quantity, int id) {
        cartItemService.updateGameToCart(quantity, id);
        return "redirect:/cart-items";
    }
    
    @GetMapping("/cart-items/delete")
    public String deleteGameFromCart(@RequestParam(name = "id") int id) {
        cartItemService.deleteGameFromCart(id);
        return "redirect:/cart-items";
    }

//    @PostMapping("/cart-items/games/{gameId}/delete")
//    public String removeGameFromCartItems(@PathParam("gameId") int gameId) {
//        cartItemService.removeGameFromCart(gameId);
//        return "redirect:/shoppingCart";
//    }  
}
