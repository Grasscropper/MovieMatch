package com.matchbase.MovieMatch.controller;

import com.matchbase.MovieMatch.model.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.PersonCast;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MovieCtrl {

    private final String apiKey = "855ad36404189ea87ef0b19ffc0a708d";
    private TmdbMovies movies = new TmdbApi(apiKey).getMovies();
    private TmdbSearch tmdbSearch = new TmdbApi(apiKey).getSearch();
    private String query;



    @RequestMapping(value = "/search/movies")
    public List<MovieDb> movieSearchResults(@RequestParam(value = "query") String searchString, @RequestParam(value = "page") int page) {
        MovieResultsPage searchResults = tmdbSearch.searchMovie(searchString, null, "en", false, page);
        List<MovieDb> resultList = searchResults.getResults();
        int totNumPages = searchResults.getTotalPages();
        List<Integer> pageNumList = new ArrayList<>();
        for (int i = 1; i <= totNumPages; i++) {
            pageNumList.add(i);
        }

        return resultList;

    }

    @RequestMapping(value = "/search/movies/numpages")
    public String numberOfPages(@RequestParam(value = "query") String searchString){
       return String.valueOf(tmdbSearch.searchMovie(searchString,null,null,false,1).getTotalPages());
    }

    @RequestMapping(value = "/movie")
    public MovieDb movieById(@RequestParam(value = "id") int id) {
        MovieDb movieDb = new TmdbApi(apiKey).getMovies().getMovie(id, null);
        String genreStringLong = movieDb.getGenres().toString();
        String genreString = genreStringLong.substring(1, genreStringLong.length() - 1).replaceAll(" \\[(.*?)\\]", "");
        MovieDb cast = movies.getMovie(id, "en", TmdbMovies.MovieMethod.credits);
        List<PersonCast> personCastList = cast.getCast();


        return movieDb;

    }
}
