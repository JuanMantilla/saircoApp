/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao;

import co.utb.softeng.moviesapp.entities.Actor;
import java.util.List;

/**
 *
 * @author Juan Mantilla
 */
public interface ActorDAO {
    
    public List<Actor> getAllActors();
    public Actor getById(Long id);
    public Actor getByName(String name);
    public void saveOrUpdate(Actor actor);
}
