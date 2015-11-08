/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services.impl;

import co.utb.softeng.moviesapp.dao.ActorDAO;
import co.utb.softeng.moviesapp.entities.Actor;
import co.utb.softeng.moviesapp.entities.Movie;
import co.utb.softeng.moviesapp.services.ActorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Mantilla
 * 
*/
@Service
@Transactional
public class ActorServiceImpl implements ActorService{
    
    @Autowired
    private ActorDAO actorDAO;

    public List<Actor> getAllActors() {
        return actorDAO.getAllActors(false);
    }

    public Actor getActorById(Long id) {
        return actorDAO.getById(id);
    }

    public List<Actor> getActorByName(String name) {
        return actorDAO.getByName(name);
    }

    public void saveOrUpdateActor(Actor actor) {
        actorDAO.saveOrUpdate(actor);
    }

    public void deleteActor(Long id) {
        actorDAO.delete(id);
    }

    @Override
    public List<Actor> getActorByMovieName(String movieName) {
        return actorDAO.getByMovieName(movieName);
    }

    @Override
    public List<Actor> getActorByMovieId(Long movieId) {
        return actorDAO.getByMovieId(movieId);
    }

    @Override
    public Actor addMoviesToActor(List<Movie> movies, Long actorId) {
        return actorDAO.addMoviesToActor(movies, actorId);
    }
}
