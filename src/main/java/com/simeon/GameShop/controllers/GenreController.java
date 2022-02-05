package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("genres")
    public String getAllGenres(Model model) {

        List<Genre> genreList = genreService.getAllGenres();

        model.addAttribute("genres", genreList);
        return "genres";
    }

    @PostMapping("genres")
    public String addGenre(Genre genre) {
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @PostMapping("genres/{id}")
    public String editGenre(@PathParam("id") int id, Genre genre) {
        genreService.addGenre(genre);
        return "redirect:/genres";

    }

    @PostMapping("genres/{id}/delete")
    public String deleteGenre(@PathParam("id") int id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}
