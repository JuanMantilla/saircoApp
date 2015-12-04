/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services.impl;

import co.utb.softeng.moviesapp.dao.EquipoDAO;
import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import co.utb.softeng.moviesapp.services.EquipoService;
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
public class EquipoServiceImpl implements EquipoService{
    
    @Autowired
    private EquipoDAO equipoDAO;

    public List<Equipo> getAllEquipos() {
        return equipoDAO.getAllEquipos(false);
    }

    public Equipo getEquipoById(Long id) {
        return equipoDAO.getById(id);
    }

    public List<Equipo> getEquipoByName(String name) {
        return equipoDAO.getByName(name);
    }

    public void saveOrUpdateEquipo(Equipo equipo) {
        equipoDAO.saveOrUpdate(equipo);
    }

    public void deleteEquipo(Long id) {
        equipoDAO.delete(id);
    }

    @Override
    public List<Equipo> getEquipoBySalonName(String salonName) {
        return equipoDAO.getBySalonName(salonName);
    }

    @Override
    public List<Equipo> getEquipoBySalonId(Long salonId) {
        return equipoDAO.getBySalonId(salonId);
    }

    @Override
    public Equipo addSalonToEquipo(String salon, Long equipoId) {
        return equipoDAO.addSalonToEquipo(salon, equipoId);
    }
}
