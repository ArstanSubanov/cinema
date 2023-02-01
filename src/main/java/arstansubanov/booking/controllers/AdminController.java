package arstansubanov.booking.controllers;

import arstansubanov.booking.model.Cinema;
import arstansubanov.booking.model.Hall;
import arstansubanov.booking.model.Movie;
import arstansubanov.booking.model.MovieSession;
import arstansubanov.booking.services.CinemaService;
import arstansubanov.booking.services.HallService;
import arstansubanov.booking.services.MovieService;
import arstansubanov.booking.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieService movieService;
    private final CinemaService cinemaService;
    private final HallService hallService;
    private final SessionService sessionService;

    @Autowired
    public AdminController(MovieService movieService, CinemaService cinemaService, HallService hallService, SessionService sessionService) {
        this.movieService = movieService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
        this.sessionService = sessionService;
    }

    //--------------------------------------Movies-------------------------------------------------------------

    @GetMapping
    public String allMovies(Model model){
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("movieSessions", sessionService.findAll());
        return "admin/admin";
    }

    @GetMapping("/movie")
    public String addMovie(@ModelAttribute("movie") Movie movie){

        return "admin/movie";
    }

    @PostMapping
    public String createMovie(@ModelAttribute("movie") Movie movie){
        movieService.save(movie);
        return "redirect:/admin";
    }

    @GetMapping("/movie/{id}")
    public String editMovie(Model model, @PathVariable("id") int id){
        model.addAttribute("movie", movieService.findMovieById(id));
        return "admin/editMovie";
    }

    @PatchMapping("/movie/{id}")
    public String updateMovie(@ModelAttribute("movie") Movie movie, @PathVariable("id") int id){
        movieService.update(id, movie);
        return "redirect:/admin";
    }

    @DeleteMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable("id") int id){
        movieService.delete(id);
        return "redirect:/admin";
    }
//--------------------------------------Cinema-------------------------------------------------------------
    @GetMapping("/cinema")
    public String addCinema(@ModelAttribute("cinema")Cinema cinema){
        return "admin/cinema";
    }

    @GetMapping("/cinema/{id}")
    public String cinemaEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("cinema", cinemaService.findCinemaById(id));
        return "admin/cinemaEdit";
    }

    @PostMapping("/cinema")
    public String createCinema(@ModelAttribute("cinema") Cinema cinema){
        cinemaService.save(cinema);
        return "redirect:/admin";
    }

    @PatchMapping("/cinema/{id}")
    public String updateCinema(@ModelAttribute("cinema") Cinema cinema, @PathVariable("id") int id){
        cinemaService.update(id, cinema);
        return "redirect:/admin";
    }

    @DeleteMapping("/cinema/delete/{id}")
    public String deleteCinema(@PathVariable("id") int id){
        cinemaService.delete(id);
        return "redirect:/admin";
    }

    //--------------------------------------Hall-------------------------------------------------------------
    @GetMapping("/hall")
    public String addHall(@ModelAttribute("hall") Hall hall, Model model){
        model.addAttribute("cinemas", cinemaService.findAll());
        return "admin/hall";
    }

    @GetMapping("/hall/{id}")
    public String hallEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("hall", hallService.findHallById(id));
        return "admin/hallEdit";
    }

    @PostMapping("/hall")
    public String createHall(@ModelAttribute("hall") Hall hall){
        hallService.save(hall);
        return "redirect:/admin";
    }

    @PatchMapping("/hall/{id}")
    public String updateHall(@ModelAttribute("hall") Hall hall, @PathVariable("id") int id){
        hallService.update(id, hall);
        return "redirect:/admin";
    }

    @DeleteMapping("/hall/delete/{id}")
    public String deleteHall(@PathVariable("id") int id){
        hallService.delete(id);
        return "redirect:/admin";
    }

    //--------------------------------------Session-------------------------------------------------------------

    @GetMapping("/movieSession")
    public String addSession(@ModelAttribute("movieSession") MovieSession movieSession, Model model){
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("halls", hallService.findAll());
        return "admin/session";
    }

    @GetMapping("/movieSession/{id}")
    public String sessionEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("movieSession", sessionService.findSessionById(id));
        return "admin/sessionEdit";
    }

    @PostMapping("/movieSession")
    public String createSession(@ModelAttribute("movieSession") MovieSession movieSession){
        sessionService.save(movieSession);
        return "redirect:/admin";
    }

    @PatchMapping("/movieSession/{id}")
    public String updateSession(@ModelAttribute("movieSession") MovieSession movieSession, @PathVariable("id") int id){
        sessionService.update(id, movieSession);
        return "redirect:/admin";
    }

    @DeleteMapping("/movieSession/delete/{id}")
    public String deleteSession(@PathVariable("id") int id){
        sessionService.delete(id);
        return "redirect:/admin";
    }
}
