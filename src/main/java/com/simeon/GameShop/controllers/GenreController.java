package com.simeon.GameShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simeon.GameShop.models.GameStudio;
import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.services.GenreService;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping("/genres")
	public String getGenres(Model model) {

		List<Genre> genreList = genreService.getGenre();
		
		model.addAttribute("genres", genreList);
		return "genres";
	}
	
	@PostMapping("/genres")
	public String addNew(Genre genre) {
		
		genreService.save(genre);
		return "redirect:/genres";
	}
	
	@PutMapping("/genres/{id}")
	public String editGenre(@PathParam("id") int id, Genre genre) {
		
		genreService.save(genre);
		return "redirect:/genres";
		
	}
	
	@DeleteMapping("/genres/{id}")
    public String deleteGenre(@PathParam("id") int id) {
		genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}
