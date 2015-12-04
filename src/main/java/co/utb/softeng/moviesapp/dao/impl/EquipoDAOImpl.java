/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.EquipoDAO;
import co.utb.softeng.moviesapp.entities.Equipo;
import co.utb.softeng.moviesapp.entities.Salon;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Mantilla
 */
@Repository
public class EquipoDAOImpl implements EquipoDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Equipo getById(Long id) {        
        return (Equipo)getSession()
                .createCriteria(Equipo.class)
                .add(Restrictions.idEq(id))
                .setFetchMode("salones",FetchMode.JOIN)
                .uniqueResult();
    }

    public List<Equipo> getByName(String name) {
        return getSession()
                .createCriteria(Equipo.class)
                .add(Restrictions.ilike("name", name, MatchMode.ANYWHERE))
                .setFetchMode("salones", FetchMode.JOIN)
                .list();
    }

    
    public void saveOrUpdate(Equipo equipo) {
        getSession().saveOrUpdate(equipo);
    }

    public void delete(Long id) {
        Equipo equipo = new Equipo();
        equipo.setId(id);
        getSession().delete(equipo);
    }

    public List<Equipo> getAllEquipos(boolean includeSalones) {
        Criteria crit =  getSession().createCriteria(Equipo.class);
        if (includeSalones) 
                crit = crit.setFetchMode("salones", FetchMode.JOIN);
         return crit.list();
    }

    @Override
    public List <Equipo> getBySalonName(String salonName) {
        DetachedCriteria subQuery = DetachedCriteria.forClass(Salon.class)
                .createCriteria("equipos")
                .add(Restrictions.ilike("name", salonName, MatchMode.ANYWHERE))
                .setProjection(Projections.id());
        
        Criteria mainCriteria = getSession()
                .createCriteria(Equipo.class)
                .add(Subqueries.propertyIn("id", subQuery))
                .setFetchMode("salones", FetchMode.JOIN);
        
        return mainCriteria.list();
    }
    
    @Override
    public List<Equipo> getBySalonId(Long salonId) {
        return getSession()
                .createCriteria(Equipo.class)
                .createCriteria("salones")
                .add(Restrictions.idEq(salonId))
                .list();
    }

    @Override
    public Equipo addSalonToEquipo(String salon, Long equipoId) {
        Session session = getSession();
        Equipo equipo = (Equipo)session.get(Equipo.class, equipoId);
        
        //Lado dominante es Salon
        
        equipo.setSalon(salon);
        session.saveOrUpdate(equipo);
        
        
//      Si el lado dominante fuese Equipo
//        for(Salon a : movies) {
//            Equipo actors = (Equipo)session.merge(a);
//            actors.getMovies().add(a);
            
//        }
        return equipo;
    }
    
}