/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services;

import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import java.util.List;

/**
 *
 * @author Juan Mantilla
 */
public interface EquipoService {
    
    public List<Equipo> getAllEquipos();
    public Equipo getEquipoById(Long id);
    public List<Equipo> getEquipoByName(String name);
    public List<Equipo> getEquipoBySalonId(Long salonId);
    public List<Equipo> getEquipoBySalonName(String salonName);
    public void saveOrUpdateEquipo(Equipo equipo);   
    public Equipo addSalonToEquipo(String salon, Long equipoId);
    public void deleteEquipo(Long id);
    
}