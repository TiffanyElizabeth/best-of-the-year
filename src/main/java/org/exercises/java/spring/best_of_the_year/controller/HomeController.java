package org.exercises.java.spring.best_of_the_year.controller;

import java.util.ArrayList;

import org.exercises.classes.Movie;
import org.exercises.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable("id") int movieId, Model model) {
        ArrayList<Movie> movies = getBestMovies();
        Movie foundMovie = null;

        for (Movie m : movies) {
            if (m.getId() == movieId) {
                foundMovie = m;
                break;
            }
        }

        if (foundMovie != null) {
            model.addAttribute("item", foundMovie);
            model.addAttribute("type", "Movie");
            return "detail";
        } else {
            return "notFound";
        }
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable("id") int songId, Model model) {
        ArrayList<Song> songs = getBestSongs();
        Song foundSong = null;

        for (Song s : songs) {
            if (s.getId() == songId) {
                foundSong = s;
                break;
            }
        }

        if (foundSong != null) {
            model.addAttribute("item", foundSong);
            model.addAttribute("type", "Song");
            return "detail";
        } else {
            return "notFound";
        }
    }

}
