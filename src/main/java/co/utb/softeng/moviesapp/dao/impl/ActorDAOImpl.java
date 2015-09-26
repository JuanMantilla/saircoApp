/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.ActorDAO;
import co.utb.softeng.moviesapp.entities.Actor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Mantilla
 */
@Repository
public class ActorDAOImpl implements ActorDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Actor getById(Long id) {
        return (Actor)getSession()
                .get(Actor.class, id);
    }

    public Actor getByName(String name) {
        return (Actor)getSession()
                .createCriteria(Actor.class)
                .add(Restrictions.ilike("name", name, MatchMode.EXACT))
                .uniqueResult();
    }

    public List<Actor> getAllActors() {
        return getSession().createCriteria(Actor.class)
                .list();
    }
    public void saveOrUpdate(Actor actor) {
        getSession().saveOrUpdate(actor);
    }
}
