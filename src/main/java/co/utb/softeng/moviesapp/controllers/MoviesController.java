/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import co.utb.softeng.moviesapp.entities.Movie;
import co.utb.softeng.moviesapp.services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William
 */

@Controller
@RequestMapping("/movie")
public class MoviesController {
    
    @Autowired
    MovieService movieService;
    
    
    @RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public @ResponseBody List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
    
    @RequestMapping(value = "/by-name/{name}", method = RequestMethod.GET)
    public @ResponseBody Movie getMovieByName(@PathVariable String name) {
        return movieService.getMovieByName(name);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Movie createMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdateMovie(movie);
        return movie;
    }
    
    @RequestMapping(value = "/",method = RequestMethod.POST) 
    public @ResponseBody Movie updateMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdateMovie(movie);
        return movie;          
    }
    
    @RequestMapping(value = "/",method = RequestMethod.DELETE) 
    public @ResponseBody Movie deleteMovie(@RequestBody Movie movie) {
        movieService.deleteMovie(movie.getId());
        return movie;          
    }
    
    
    
    
}
