/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import co.utb.softeng.moviesapp.services.SalonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/salon")
public class SalonesController {    
    @Autowired
    SalonService salonService;
    
    
    @RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public @ResponseBody List<Salon> getAllSalones() {
        return salonService.getAllSalones();
    }
    
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public @ResponseBody Salon getSalonById(@PathVariable Long id) {
        return salonService.getSalonById(id);
    }
    
    @RequestMapping(value ={ "/name/{name}"}, method = RequestMethod.GET)
    public @ResponseBody List<Salon> getSalonByName(@PathVariable String name) {
        return salonService.getSalonByName(name);
    }
    
    @RequestMapping(value = {"/salon/{equipoId}"}, method = RequestMethod.GET)
    public @ResponseBody List<Salon> getSalonByEquipoId(@PathVariable Long equipoId) {
        return salonService.getSalonByEquipoId(equipoId);
    }
    
    @RequestMapping(value = {"/equipo/name/{name}"}, method = RequestMethod.GET)
    public @ResponseBody List<Salon> getSalonByEquipoName(@PathVariable String name) {
        return salonService.getSalonByEquipoName(name);
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT)
    public @ResponseBody Salon createSalon(@RequestBody Salon salon) {
        salonService.saveOrUpdateSalon(salon);
        return salon;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = {"/"},method = RequestMethod.POST) 
    public @ResponseBody Salon updateSalon(@RequestBody Salon salon) {
        salonService.saveOrUpdateSalon(salon);
        return salon;          
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value={"/{id}/equipos"}, method = RequestMethod.POST)
    public @ResponseBody Salon addEquiposToSalon(@RequestBody List<Equipo> equipos, 
            @PathVariable Long salonId) {
        return salonService.addEquiposToSalon(equipos, salonId);
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = {"/"},method = RequestMethod.DELETE) 
    public @ResponseBody Salon deleteSalon(@RequestBody Salon salon) {
        salonService.deleteSalon(salon.getId());
        return salon;          
    }
    
    
    
}