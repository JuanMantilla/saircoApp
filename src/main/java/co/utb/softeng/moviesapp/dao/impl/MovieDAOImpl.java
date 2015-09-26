/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao.impl;

import co.utb.softeng.moviesapp.dao.MovieDAO;
import co.utb.softeng.moviesapp.entities.Movie;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
        return (Movie)getSession()
                .get(Movie.class, id);
    }

    public Movie getByName(String name) {
        return (Movie)getSession()
                .createCriteria(Movie.class)
                .add(Restrictions.ilike("name", name, MatchMode.EXACT))
                .uniqueResult();
    }

    
    public void saveOrUpdate(Movie movie) {
        getSession().saveOrUpdate(movie);
    }

    public void delete(Long id) {
        Movie movie = new Movie();
        movie.setId(id);
        getSession().delete(movie);
    }

    public List<Movie> getAllMovies() {
        return getSession().createCriteria(Movie.class)
                .list();
    }
    
}
