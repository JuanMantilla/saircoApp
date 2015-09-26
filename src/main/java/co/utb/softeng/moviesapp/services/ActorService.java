/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services;

import co.utb.softeng.moviesapp.entities.Actor;
import java.util.List;

/**
 *
 * @author Juan Mantilla
 */
public interface ActorService {
    
    public List<Actor> getAllActors();
    public Actor getActorById(Long id);
    public Actor getActorByName(String name);
    public void saveOrUpdate(Actor actor);
    
}
