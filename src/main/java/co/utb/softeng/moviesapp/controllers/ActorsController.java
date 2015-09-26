/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import co.utb.softeng.moviesapp.entities.Actor;
import co.utb.softeng.moviesapp.services.ActorService;
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
<<<<<<< HEAD
 * @author Juan Mantilla
=======
 * @author Juan Mantila
>>>>>>> origin/master
 */

@Controller
@RequestMapping("/actor")
public class ActorsController {
    
    @Autowired
    ActorService actorService;
    
    
    @RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public @ResponseBody List<Actor> getAllActors() {
        return actorService.getAllActors();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }
    
    @RequestMapping(value = "/by-name/{name}", method = RequestMethod.GET)
    public @ResponseBody Actor getActorByName(@PathVariable String name) {
        return actorService.getActorByName(name);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Actor createActor(@RequestBody Actor actor) {
        actorService.saveOrUpdate(actor);
        return actor;
    }
    
 
    
    
}
