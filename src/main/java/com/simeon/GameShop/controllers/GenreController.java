package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.services.CartItemService;
import com.simeon.GameShop.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;
    
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("genres")
    public String getAllGenres(Model model) {
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("genres", genreList);
        
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);
        return "genres";
    }

    @PostMapping("genres")
    public String addGenre(Genre genre) {
        genreService.addEditGenre(genre);
        return "redirect:/genres";
    }

    @PostMapping("/genres/edit")
    public String editGenre(Genre genre) {
        genreService.addEditGenre(genre);
        return "redirect:/genres";
    }
    
    @GetMapping("/genres/delete")
    public String deleteGenre(@RequestParam(name = "id") int id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }

//    @PostMapping("genres/{id}/delete")
//    public String deleteGenre(@PathParam("id") int id) {
//        genreService.deleteGenre(id);
//        return "redirect:/genres";
//    }
}
