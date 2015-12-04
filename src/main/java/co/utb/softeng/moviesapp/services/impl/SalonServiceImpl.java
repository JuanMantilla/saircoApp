/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services.impl;

import co.utb.softeng.moviesapp.dao.SalonDAO;
import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import co.utb.softeng.moviesapp.services.SalonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author William
 */
@Service
@Transactional
public class SalonServiceImpl implements SalonService{
    
    @Autowired
    private SalonDAO salonDAO;

    public List<Salon> getAllSalones() {
        return salonDAO.getAllSalones(false);
    }

    public Salon getSalonById(Long id) {
        return salonDAO.getById(id);
    }

    public List<Salon> getSalonByName(String name) {
        return salonDAO.getByName(name);
    }

    public void saveOrUpdateSalon(Salon salon) {
        salonDAO.saveOrUpdate(salon);
    }

    public void deleteSalon(Long id) {
        salonDAO.delete(id);
    }

    @Override
    public List<Salon> getSalonByEquipoName(String equipoName) {
        return salonDAO.getByEquipoName(equipoName);
    }

    @Override
    public List<Salon> getSalonByEquipoId(Long equipoId) {
        return salonDAO.getByEquipoId(equipoId);
    }

    @Override
    public Salon addEquiposToSalon(List<Equipo> equipos, Long salonId) {
        return salonDAO.addEquiposToSalon(equipos, salonId);
    }
    
}
