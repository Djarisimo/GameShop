package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Platform;
import com.simeon.GameShop.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping("platforms")
    public String getAllPlatforms(Model model) {

        List<Platform> platformList = platformService.getAllPlatforms();

        model.addAttribute("platforms", platformList);
        return "platforms";
    }

    @PostMapping("platforms")
    public String addPlatform(Platform platform) {
        platformService.addPlatform(platform);
        return "redirect:/platforms";
    }

    @PostMapping("platforms/{id}")
    public String editPlatform(@PathParam("id") int id, Platform platform) {
        platformService.updatePlatform(id, platform);
        return "redirect:/platforms";
    }

//    @PostMapping("platforms/{id}/delete")
//    public String deletePlatform(@PathParam("id") int id) {
//        platformService.deletePlatform(id);
//        return "redirect:/platforms";
//    }
    
    @RequestMapping(value = "/platforms/delete", method = RequestMethod.GET)
    public String deletePlatform(@RequestParam(name = "id") int id) {
		platformService.deletePlatform(id);
        return "redirect:/platforms";
    }
}
