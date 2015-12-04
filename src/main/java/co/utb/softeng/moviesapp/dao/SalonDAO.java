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
 * @author William
 */
public interface SalonDAO {
    
    public List<Salon> getAllSalones(boolean includeEquipos);
    public Salon getById(Long id);
    public List<Salon> getByName(String name);
    public List<Salon> getByEquipoId(Long equipoId);
    public List<Salon> getByEquipoName(String equipoName);
    public Salon addEquiposToSalon(List<Equipo> equipos, Long salonId);
    public void saveOrUpdate(Salon salon);
    public void delete(Long id);
    
    
}