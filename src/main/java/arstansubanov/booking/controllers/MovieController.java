package arstansubanov.booking.controllers;

import arstansubanov.booking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("movies", movieService.findByActiveTrue());

        return "movies/index";
    }

    @GetMapping("/{id}")
    public String showMovie(@PathVariable("id") int id, Model model){
        model.addAttribute("movie", movieService.findMovieById(id));
        return "movies/show";
    }
}
