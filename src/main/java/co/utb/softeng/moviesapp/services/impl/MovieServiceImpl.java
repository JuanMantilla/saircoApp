/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.services.impl;

import co.utb.softeng.moviesapp.dao.MovieDAO;
import co.utb.softeng.moviesapp.entities.Movie;
import co.utb.softeng.moviesapp.services.MovieService;
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
public class MovieServiceImpl implements MovieService{
    
    @Autowired
    private MovieDAO movieDAO;

    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public Movie getMovieById(Long id) {
        return movieDAO.getById(id);
    }

    public Movie getMovieByName(String name) {
        return movieDAO.getByName(name);
    }

    public void saveOrUpdateMovie(Movie movie) {
        movieDAO.saveOrUpdate(movie);
    }

    public void deleteMovie(Long id) {
        movieDAO.delete(id);
    }
    
}
