
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
 * @author William
 */
public interface SalonService {
    
    public List<Salon> getAllSalones();
    public Salon getSalonById(Long id);
    public List<Salon> getSalonByName(String name);
    public List<Salon> getSalonByEquipoId(Long equipoId);
    public List<Salon> getSalonByEquipoName(String equipoName);
    public void saveOrUpdateSalon(Salon salon);
    
    public Salon addEquiposToSalon(List<Equipo> equipos, Long salonId);
    public void deleteSalon(Long id);
    
    
}