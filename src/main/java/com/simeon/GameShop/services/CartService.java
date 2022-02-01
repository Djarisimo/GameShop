package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Cart;
import com.simeon.GameShop.models.Game;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.repositories.CartRepository;
import java.util.Optional;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	// Return all genres
	public List<Cart> getCart(){
		return cartRepository.findAll();
	}
        
        public Optional<Cart> getCartByGameId(int gameId){
		return cartRepository.findByGameId(gameId);
	}
                  
	// Save genres
//	public void save(Game game) {
//		Optional<Cart> cart = cartRepository.findByGameId(game.getId());
//		if(cart.isPresent()) {
//			cart.setQuantity(cart.getQuantity()++);
//			cartRepository.save(cart);
//		} else {
//			cartRepository.save(new Cart(game, 1));
//		}
//	}
		
	// Delete genres
	public void deleteFromCart(int id) {
		cartRepository.deleteById(id);
	}
}
