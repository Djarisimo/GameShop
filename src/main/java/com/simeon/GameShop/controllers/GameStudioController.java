package com.simeon.GameShop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simeon.GameShop.models.GameStudio;
import com.simeon.GameShop.services.GameStudioService;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class GameStudioController {

	@Autowired
	private GameStudioService gameStudioService;
	
	@GetMapping("/studios")
	public String getStudios(Model model) {
		
		List<GameStudio> studioList = gameStudioService.getStudios();
		
		model.addAttribute("studios", studioList);
		
		return "studios";
	}
	
	@PostMapping("/studios")
	public String addNew(GameStudio studio) {
		
		gameStudioService.save(studio);
		return "redirect:/studios";
	}
	
	@PutMapping("/studios/{id}")
	public String editStudio(@PathParam("id") int id, GameStudio studio) {
		
		gameStudioService.save(studio);
		return "redirect:/studios";
		
	}
	
	@DeleteMapping("/studios/{id}")
    public String deleteStudio(@PathParam("id") int id) {
        gameStudioService.deleteStudio(id);
        return "redirect:/studios";
    }
}
