package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CommonObject;
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
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.GameStudioService;
import com.simeon.GameShop.services.GameService;
import com.simeon.GameShop.services.GenreService;
import com.simeon.GameShop.services.PlatformService;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameStudioService gameStudioService;

	@Autowired
	private GenreService genreService;
        
        @Autowired
	private PlatformService platformService;

        
	@GetMapping("/games")
	public String getGames(Model model, String keyword) {
					
		model.addAttribute("studios", gameStudioService.getStudios());
		
		model.addAttribute("genres", genreService.getGenre());
                
                model.addAttribute("platforms", platformService.getPlatform());
                         
                if(keyword!=null) {
                    model.addAttribute("games", gameService.findByKeyword(keyword));
                }
                else
                {
                    model.addAttribute("games", gameService.getGames());
                }
		
		return "games";
	}   
         
	//games
	@PostMapping("/games")
	public String addNew(Game game) {           
                       
		gameService.save(game);
		return "redirect:/games";
	}
    
        //PutMapping/games/{id}  //PathParam
	@PutMapping("/games/{id}")
	public String editGame(@PathParam("id") int id, Game game) {
		
		gameService.save(game);
		return "redirect:/games";
                
	}
	
        //DeleteMapping/games/{id}
	@DeleteMapping("/games/{id}")
        public String deleteGame(@PathParam("id") int id) {
            
		gameService.deleteGame(id);
                return "redirect:/games";
        }    
}
