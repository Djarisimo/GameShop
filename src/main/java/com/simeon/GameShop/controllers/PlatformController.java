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
import com.simeon.GameShop.models.Platform;
import com.simeon.GameShop.services.PlatformService;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PlatformController {

	@Autowired
	private PlatformService platformService;
	
	@GetMapping("/platforms")
	public String getPlatforms(Model model) {

		List<Platform> platformList = platformService.getPlatform();
		
		model.addAttribute("platforms", platformList);
		return "platforms";
	}
	
	@PostMapping("/platforms")
	public String addNew(Platform platform) {
            
		platformService.save(platform);
		return "redirect:/platforms";
	}
	
	@PutMapping("/platforms/{id}")
	public String editPlatform(@PathParam("id") int id, Platform platform) {
		
		platformService.save(platform);
		return "redirect:/platforms";		
	}
	
	@DeleteMapping("/platforms/{id}")
    public String deletePlatform(@PathParam("id") int id) {
		platformService.deletePlatform(id);
        return "redirect:/platforms";
    }
}
