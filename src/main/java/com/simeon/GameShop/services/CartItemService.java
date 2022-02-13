package com.simeon.GameShop.services;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void addGameToCart(Game game) {
        Optional<CartItem> optionalItem = findByGameId(game.getId());
        if (optionalItem.isPresent()) {
            CartItem cartItems = optionalItem.get();
            cartItems.setQuantity(cartItems.getQuantity() + 1);
            cartItemRepository.save(cartItems);
        } else {
            cartItemRepository.save(new CartItem(1, game));
        }
    }
    
    public CartItem updateGameToCart(int quantity, int id) {
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }
    
    private Optional<CartItem> findByGameId(int gameId) {
        return cartItemRepository.findByGameId(gameId);
    }
    
    public void deleteGameFromCart(int id) {
        cartItemRepository.deleteById(id);
    }  
    
//    public void removeGameFromCart(int gameId) {
//        Optional<CartItem> optionalItem = findByGameId(gameId);
//        if (optionalItem.isPresent()) {
//            CartItem cartItems = optionalItem.get();
//            if (cartItems.getQuantity() == 1) {
//                cartItemRepository.delete(cartItems);
//            } else {
//                cartItems.setQuantity(cartItems.getQuantity() - 1);
//                cartItemRepository.save(cartItems);
//            }
//        }
//        // Consider throwing an error if cart item not found by id
//    } 
}
