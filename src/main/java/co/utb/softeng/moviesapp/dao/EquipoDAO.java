/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao;

import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import java.util.List;

/**
 *
 * @author Juan Mantilla
 */
public interface EquipoDAO {
    
    public List<Equipo> getAllEquipos(boolean includeEquipos);
    public Equipo getById(Long id);
    public List<Equipo> getByName(String name);
    public List<Equipo> getBySalonName(String equipoName);
    public List<Equipo> getBySalonId(Long salonId);
    public Equipo addSalonToEquipo(String salon, Long equipoId);
    public void saveOrUpdate(Equipo equipo);
    public void delete(Long id);
}