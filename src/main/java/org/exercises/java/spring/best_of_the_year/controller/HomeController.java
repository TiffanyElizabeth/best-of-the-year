package org.exercises.java.spring.best_of_the_year.controller;

import java.util.ArrayList;

import org.exercises.classes.Movie;
import org.exercises.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private ArrayList<Movie> getBestMovies() {
        int i = 0;
        Movie atonement = new Movie(i++, "Atonement");
        Movie budapestHotel = new Movie(i++, "The Grand Budapest Hotel");
        Movie brooklyn = new Movie(i++, "Brooklyn");
        Movie littleWomen = new Movie(i++, "Little Women");

        ArrayList<Movie> saoriseRonanMovies = new ArrayList<Movie>();

        saoriseRonanMovies.add(atonement);
        saoriseRonanMovies.add(budapestHotel);
        saoriseRonanMovies.add(brooklyn);
        saoriseRonanMovies.add(littleWomen);

        return saoriseRonanMovies;
    }

    private ArrayList<Song> getBestSongs() {
        int i = 0;
        Song spiritBird = new Song(i++, "Spirit Bird");
        Song whereToNow = new Song(i++, "Where to Now");
        Song stoneyCreek = new Song(i++, "Stoney Creek");
        Song followTheSun = new Song(i++, "Follow the Sun");

        ArrayList<Song> xavierRuddSongs = new ArrayList<Song>();

        xavierRuddSongs.add(spiritBird);
        xavierRuddSongs.add(whereToNow);
        xavierRuddSongs.add(stoneyCreek);
        xavierRuddSongs.add(followTheSun);

        return xavierRuddSongs;
    }

    @GetMapping("/")
    public String bestYear(Model model) {
        model.addAttribute("name", "java");
        return "home";
    }

    @GetMapping("/movies")
    public String moviesString(Model model) {
        model.addAttribute("movies", getBestMovies());

        return "movies";
    }

    @GetMapping("/songs")
    public String songsString(Model model) {
        model.addAttribute("songs", getBestSongs());

        return "songs";
    }
}
