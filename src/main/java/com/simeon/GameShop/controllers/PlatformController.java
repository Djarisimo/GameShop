package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Platform;
import com.simeon.GameShop.services.CartItemService;
import com.simeon.GameShop.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlatformController {

    @Autowired
    private PlatformService platformService;
    
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("platforms")
    public String getAllPlatforms(Model model) {
        List<Platform> platformList = platformService.getAllPlatforms();
        model.addAttribute("platforms", platformList);
        
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);
        return "platforms";
    }

    @PostMapping("platforms")
    public String addPlatform(Platform platform) {
        platformService.addEditPlatform(platform);
        return "redirect:/platforms";
    }

    @PostMapping("platforms/edit")
    public String editPlatform(Platform platform) {
        platformService.addEditPlatform(platform);
        return "redirect:/platforms";
    }
    
    @GetMapping("/platforms/delete")
    public String deletePlatform(@RequestParam(name = "id") int id) {
        platformService.deletePlatform(id);
        return "redirect:/platforms";
    }

//    @PostMapping("platforms/{id}/delete")
//    public String deletePlatform(@PathParam("id") int id) {
//        platformService.deletePlatform(id);
//        return "redirect:/platforms";
//    }
}
