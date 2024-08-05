package com.example.kinoapp.web;

import com.example.kinoapp.model.Film;
import com.example.kinoapp.model.FilmProekciiView;
import com.example.kinoapp.model.GlumciVoFilmView;
import com.example.kinoapp.model.Glumec;
import com.example.kinoapp.service.FilmProekcijaViewService;
import com.example.kinoapp.service.FilmService;
import com.example.kinoapp.service.GlumciVoFilmViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    private final FilmService filmService;
    private final FilmProekcijaViewService filmProekcijaViewService;
    private final GlumciVoFilmViewService glumciVoFilmViewService;

    public MoviesController(FilmService filmService, FilmProekcijaViewService filmProekcijaViewService, GlumciVoFilmViewService glumciVoFilmViewService) {
        this.filmService = filmService;
        this.filmProekcijaViewService = filmProekcijaViewService;
        this.glumciVoFilmViewService = glumciVoFilmViewService;
    }

    @GetMapping()
    private String showMoviesPage(Model model){
        List<Film> filmovi=this.filmService.findAll();
        model.addAttribute("filmovi", filmovi);
        return "index";
    }
    @GetMapping("/info")
    private String showMoviesPage(@RequestParam(required = false) String error, @RequestParam(required = false) String naslov, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Film> movies=this.filmService.findAll();
        model.addAttribute("movies",movies);

        if (naslov != null && !naslov.isEmpty()) {
            List<Glumec> movieGenre = filmService.findGlumciVoFilm(naslov);
            model.addAttribute("movieGenre", movieGenre);
        }

        return "movie";
    }

    @GetMapping("/proekcii/{id_film}")
    public String getProekcii(@PathVariable Integer id_film,
                              Model model){
        List<FilmProekciiView> proekcii= this.filmProekcijaViewService.findAllByFilm(id_film);
        Film film =this.filmService.findById(id_film);
        List<GlumciVoFilmView> glumci = this.glumciVoFilmViewService.findAllByFilm(id_film);
        model.addAttribute("proekcii",proekcii);
        model.addAttribute("film", film);
        model.addAttribute("glumci",glumci);
        return "proekcii";
    }


    @GetMapping("/movies/add")
    private String showAddMovieForm() {
        return "add_new_movie_form"; // Ова е името на HTML страницата за додавање на нов филм
    }

    @PostMapping("/add")
    private String addNewMovie(
            @RequestParam Integer idFilm,
            @RequestParam String naslov,
            @RequestParam String rejting,
            @RequestParam String vremetraenje,
            @RequestParam String zanr,
            @RequestParam String jazik,
            @RequestParam String slika
    ) {
        Film film = new Film(idFilm, null, naslov, rejting, vremetraenje, zanr, jazik, slika);
        filmService.save(film);
        return "redirect:/movies"; // Пренасочување кон страницата за сите филмови откако ќе се додаде нов филм
    }
}
