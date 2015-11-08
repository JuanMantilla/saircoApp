/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services;

import co.utb.softeng.moviesapp.entities.Actor;
import co.utb.softeng.moviesapp.entities.Movie;
import java.util.List;

/**
 *
 * @author Juan Mantilla
 */
public interface ActorService {
    
    public List<Actor> getAllActors();
    public Actor getActorById(Long id);
    public List<Actor> getActorByName(String name);
    public List<Actor> getActorByMovieId(Long actorId);
    public List<Actor> getActorByMovieName(String actorName);
    public void saveOrUpdateActor(Actor movie);
    
    public Actor addMoviesToActor(List<Movie> movies, Long actorId);
    public void deleteActor(Long id);
    
}
