package com.simeon.GameShop.controllers;

import com.simeon.GameShop.models.CartItem;
import com.simeon.GameShop.models.Game;
import com.simeon.GameShop.services.CartItemService;
import com.simeon.GameShop.services.GameService;
import com.simeon.GameShop.services.GenreService;
import com.simeon.GameShop.services.PlatformService;
import com.simeon.GameShop.services.StudioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;
    
    @Autowired
    private CartItemService cartItemService;


    @GetMapping("/")
    public String getAllGames(Model model, String keyword, @RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        
        Page<Game> gamePage = gameService.findPaginated(currentPage, pageSize);

        model.addAttribute("games", gamePage);

        int totalPages = gamePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
        model.addAttribute("studios", studioService.getAllStudios());
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("platforms", platformService.getAllPlatforms());
        
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);

        return "games";
    }
    
    @GetMapping("search")
    public String findByNameOrPriceLike(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("games", gameService.findByNameOrPriceLike(keyword));
        
        List<CartItem> list = cartItemService.getAllCartItems();
        model.addAttribute("shoppingCart", list);
        return "games";
    }

    @PostMapping("games")
    public String addGame(Game game) {
        gameService.addEditGame(game);
        return "redirect:/";
    }

//    @PostMapping("games/{id}")
//    public String updateGame(@PathParam("id") int id, Game game) {
//        gameService.updateGame(id, game);
//        return "redirect:/games";
//
//    }
    
    @PostMapping("/games/edit")
    public String editGame(Game game) {
        gameService.addEditGame(game);
        return "redirect:/";
    }

//    @PostMapping("games/{id}/delete")
//    public String deleteGame(@PathParam("id") int id) {
//        gameService.deleteGame(id);
//        return "redirect:/games";
//    }
        
    @GetMapping("/games/delete")
    public String deleteGame(@RequestParam(name = "id") int id) {
        gameService.deleteGame(id);
        return "redirect:/";
    }
}
