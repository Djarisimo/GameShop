package com.simeon.GameShop;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.services.CartItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("index")
    public String index(Model model) {
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout() {
        return "login";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }
}
