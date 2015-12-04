/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import co.utb.softeng.moviesapp.services.EquipoService;
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
@RequestMapping("/equipo")
public class EquiposController {
    
    @Autowired
    EquipoService equipoService;
    
    
    @RequestMapping(value={"/", ""}, method = RequestMethod.GET)
    public @ResponseBody List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }
    
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public @ResponseBody Equipo getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }
    
    @RequestMapping(value = {"/name/{name}"}, method = RequestMethod.GET)
    public @ResponseBody List<Equipo> getSalonByName(@PathVariable String name) {
        return equipoService.getEquipoByName(name);
    }
    
    @RequestMapping(value = {"/equipo/{equipoId}"}, method = RequestMethod.GET)
    public @ResponseBody List<Equipo> getSalonByEquipoId(@PathVariable Long equipoId) {
        return equipoService.getEquipoBySalonId(equipoId);
    }
    
    @RequestMapping(value ={ "/equipo/name/{name}"}, method = RequestMethod.GET)
    public @ResponseBody List<Equipo> getSalonByEquipoName(@PathVariable String name) {
        return equipoService.getEquipoBySalonName(name);
    }
    
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT)
    public @ResponseBody Equipo createEquipo(@RequestBody Equipo equipo) {
        equipoService.saveOrUpdateEquipo(equipo);
        return equipo;
    }
    
    @RequestMapping(value = {"/equipo/{equipoId}"},method = RequestMethod.POST) 
    public @ResponseBody Equipo updateEquipo(@RequestBody Equipo equipo) {
        equipoService.saveOrUpdateEquipo(equipo); 
        return equipo;          
    }
    
    @RequestMapping(value={"/{equipoId}/salon"}, method = RequestMethod.POST)
    public @ResponseBody Equipo addSalonToEquipo(@RequestBody String salon, 
            @PathVariable Long equipoId) {
        return equipoService.addSalonToEquipo(salon, equipoId);
    }
    
    @RequestMapping(value = {"/"},method = RequestMethod.DELETE) 
    public @ResponseBody Equipo deleteEquipo(@RequestBody Equipo equipo) {
        equipoService.deleteEquipo(equipo.getId());
        return equipo;          
    }
}
