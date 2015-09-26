/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.dao;

import co.utb.softeng.moviesapp.entities.Movie;
import java.util.List;

/**
 *
 * @author William
 */
public interface MovieDAO {
    
    public List<Movie> getAllMovies();
    public Movie getById(Long id);
    public Movie getByName(String name);
    public void saveOrUpdate(Movie movie);
    public void delete(Long id);
    
}
