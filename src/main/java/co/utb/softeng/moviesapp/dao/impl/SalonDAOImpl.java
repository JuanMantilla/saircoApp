/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.SalonDAO;
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
 * @author William
 */
@Repository
public class SalonDAOImpl implements SalonDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Salon getById(Long id) {
//        return (Salon)getSession()
//                .get(Salon.class, id);
        
        return (Salon)getSession()
                .createCriteria(Salon.class)
                .add(Restrictions.idEq(id))
                .setFetchMode("equipos",FetchMode.JOIN)
                .uniqueResult();
    }

    public List<Salon> getByName(String name) {
        return getSession()
                .createCriteria(Salon.class)
                .add(Restrictions.ilike("name", name, MatchMode.ANYWHERE))
                .setFetchMode("equipos", FetchMode.JOIN)
                .list();
    }

    
    public void saveOrUpdate(Salon salon) {
        getSession().saveOrUpdate(salon);
    }

    public void delete(Long id) {
        Salon salon = new Salon();
        salon.setId(id);
        getSession().delete(salon);
    }

    public List<Salon> getAllSalones(boolean includeEquipos) {
        Criteria crit =  getSession().createCriteria(Salon.class);
        if (includeEquipos) 
                crit = crit.setFetchMode("equipos", FetchMode.JOIN);
         return crit.list();
    }

    @Override
    public List<Salon> getByEquipoName(String equipoName) {
        Criterion crit1 = Restrictions.ilike("name", equipoName, MatchMode.ANYWHERE);        
        
        DetachedCriteria subQuery = DetachedCriteria.forClass(Salon.class)
                .createCriteria("equipos")
                .add(Restrictions.or(crit1))
                .setProjection(Projections.id());
        
        Criteria mainCriteria = getSession()
                .createCriteria(Salon.class)
                .add(Subqueries.propertyIn("id", subQuery))
                .setFetchMode("equipos", FetchMode.JOIN);
        
        return mainCriteria.list();
    }

    @Override
    public List<Salon> getByEquipoId(Long equipoId) {
        return getSession()
                .createCriteria(Salon.class)
                .createCriteria("equipos")
                .add(Restrictions.idEq(equipoId))
                .list();
    }

    @Override
    public Salon addEquiposToSalon(List<Equipo> equipos, Long SalonId) {
        Session session = getSession();
        Salon salon = (Salon)session.get(Salon.class, SalonId);
        
        //Lado dominante es Salon
        salon.setEquipos(equipos);
        session.saveOrUpdate(salon);
        
        
//      Si el lado dominante fuese Equipo
//     for(Equipo a : actors) {
//            Salon movies = (Salon)session.merge(a);
//            movies.getActors().add(a);
//            
//        }
        return salon;
    }
    
}
