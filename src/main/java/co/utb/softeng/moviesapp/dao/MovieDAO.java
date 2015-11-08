/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao;

import co.utb.softeng.moviesapp.entities.Actor;
import co.utb.softeng.moviesapp.entities.Movie;
import java.util.List;

/**
 *
 * @author William
 */
public interface MovieDAO {
    
    public List<Movie> getAllMovies(boolean includeActors);
    public Movie getById(Long id);
    public List<Movie> getByName(String name);
    public List<Movie> getByActorId(Long actorId);
    public List<Movie> getByActorName(String actorName);
    public Movie addActorsToMovie(List<Actor> actors, Long movieId);
    public void saveOrUpdate(Movie movie);
    public void delete(Long id);
    
    
}
