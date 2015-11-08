/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.ActorDAO;
import co.utb.softeng.moviesapp.entities.Actor;
import co.utb.softeng.moviesapp.entities.Movie;
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
public class ActorDAOImpl implements ActorDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Actor getById(Long id) {        
        return (Actor)getSession()
                .createCriteria(Actor.class)
                .add(Restrictions.idEq(id))
                .setFetchMode("movies",FetchMode.JOIN)
                .uniqueResult();
    }

    public List<Actor> getByName(String name) {
        return getSession()
                .createCriteria(Actor.class)
                .add(Restrictions.ilike("name", name, MatchMode.ANYWHERE))
                .setFetchMode("movies", FetchMode.JOIN)
                .list();
    }

    
    public void saveOrUpdate(Actor actor) {
        getSession().saveOrUpdate(actor);
    }

    public void delete(Long id) {
        Actor actor = new Actor();
        actor.setId(id);
        getSession().delete(actor);
    }

    public List<Actor> getAllActors(boolean includeMovies) {
        Criteria crit =  getSession().createCriteria(Actor.class);
        if (includeMovies) 
                crit = crit.setFetchMode("movies", FetchMode.JOIN);
         return crit.list();
    }

    @Override
    public List<Actor> getByMovieName(String movieName) {
        DetachedCriteria subQuery = DetachedCriteria.forClass(Movie.class)
                .createCriteria("actors")
                .add(Restrictions.ilike("name", movieName, MatchMode.ANYWHERE))
                .setProjection(Projections.id());
        
        Criteria mainCriteria = getSession()
                .createCriteria(Actor.class)
                .add(Subqueries.propertyIn("id", subQuery))
                .setFetchMode("movies", FetchMode.JOIN);
        
        return mainCriteria.list();
    }

    @Override
    public List<Actor> getByMovieId(Long movieId) {
        return getSession()
                .createCriteria(Actor.class)
                .createCriteria("movies")
                .add(Restrictions.idEq(movieId))
                .list();
    }

    @Override
    public Actor addMoviesToActor(List<Movie> movies, Long actorId) {
        Session session = getSession();
        Actor actor = (Actor)session.get(Actor.class, actorId);
        
        //Lado dominante es Movie
        actor.setMovies(movies);
        session.saveOrUpdate(actor);
        
        
//      Si el lado dominante fuese Actor
//        for(Movie a : movies) {
//            Actor actors = (Actor)session.merge(a);
//            actors.getMovies().add(a);
            
//        }
        return actor;
    }
    
}