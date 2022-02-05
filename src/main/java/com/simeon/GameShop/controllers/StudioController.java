package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.Studio;
import com.simeon.GameShop.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping("studios")
    public String getAllStudios(Model model) {

        List<Studio> studioList = studioService.getAllStudios();

        model.addAttribute("studios", studioList);

        return "studios";
    }

    @PostMapping("studios")
    public String addStudio(Studio studio) {

        studioService.addStudio(studio);
        return "redirect:/studios";
    }

    @PostMapping("studios/{id}")
    public String updateStudio(@PathParam("id") int id, Studio studio) {

        studioService.updateStudio(id, studio);
        return "redirect:/studios";

    }

    @PostMapping("studios/{id}/delete")
    public String deleteStudio(@PathParam("id") int id) {
        studioService.deleteStudio(id);
        return "redirect:/studios";
    }
}
