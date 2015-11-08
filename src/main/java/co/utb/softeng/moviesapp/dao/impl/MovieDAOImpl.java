/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.MovieDAO;
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
 * @author William
 */
@Repository
public class MovieDAOImpl implements MovieDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Movie getById(Long id) {
//        return (Movie)getSession()
//                .get(Movie.class, id);
        
        return (Movie)getSession()
                .createCriteria(Movie.class)
                .add(Restrictions.idEq(id))
                .setFetchMode("actors",FetchMode.JOIN)
                .uniqueResult();
    }

    public List<Movie> getByName(String name) {
        return getSession()
                .createCriteria(Movie.class)
                .add(Restrictions.ilike("name", name, MatchMode.ANYWHERE))
                .setFetchMode("actors", FetchMode.JOIN)
                .list();
    }

    
    public void saveOrUpdate(Movie movie) {
        getSession().saveOrUpdate(movie);
    }

    public void delete(Long id) {
        Movie movie = new Movie();
        movie.setId(id);
        getSession().delete(movie);
    }

    public List<Movie> getAllMovies(boolean includeActors) {
        Criteria crit =  getSession().createCriteria(Movie.class);
        if (includeActors) 
                crit = crit.setFetchMode("actors", FetchMode.JOIN);
         return crit.list();
    }

    @Override
    public List<Movie> getByActorName(String actorName) {
        Criterion crit1 = Restrictions.ilike("firstName", actorName, MatchMode.ANYWHERE);
        Criterion crit2 = Restrictions.ilike("lastName", actorName, MatchMode.ANYWHERE);
        
        DetachedCriteria subQuery = DetachedCriteria.forClass(Movie.class)
                .createCriteria("actors")
                .add(Restrictions.or(crit1, crit2))
                .setProjection(Projections.id());
        
        Criteria mainCriteria = getSession()
                .createCriteria(Movie.class)
                .add(Subqueries.propertyIn("id", subQuery))
                .setFetchMode("actors", FetchMode.JOIN);
        
        return mainCriteria.list();
    }

    @Override
    public List<Movie> getByActorId(Long actorId) {
        return getSession()
                .createCriteria(Movie.class)
                .createCriteria("actors")
                .add(Restrictions.idEq(actorId))
                .list();
    }

    @Override
    public Movie addActorsToMovie(List<Actor> actors, Long movieId) {
        Session session = getSession();
        Movie movie = (Movie)session.get(Movie.class, movieId);
        
        //Lado dominante es Movie
        movie.setActors(actors);
        session.saveOrUpdate(movie);
        
        
//      Si el lado dominante fuese Actor
//     for(Actor a : actors) {
//            Movie movies = (Movie)session.merge(a);
//            movies.getActors().add(a);
//            
//        }
        return movie;
    }
    
}
