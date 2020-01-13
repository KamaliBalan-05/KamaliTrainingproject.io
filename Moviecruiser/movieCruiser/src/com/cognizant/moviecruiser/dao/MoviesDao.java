package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public interface MoviesDao {

	public List<Movies> getMoviesListAdmin();

	public List<Movies> getMoviesListCustomer();

	public void modifyMovies(Movies movies);

	public Movies getMovies(Long moviesId);

}
