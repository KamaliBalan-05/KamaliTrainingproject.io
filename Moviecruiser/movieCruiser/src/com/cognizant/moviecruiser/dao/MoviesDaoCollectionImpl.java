package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movies> moviesList;

	public MoviesDaoCollectionImpl() {
		super();
		if (moviesList == null) {
			moviesList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", true);
			Movies itemTwo = new Movies(2L, "The Avengers", 1518812988L, true,
					new DateUtil().convertToDate("23/03/2017"), "Superhero", false);
			Movies itemThree = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("12/12/2019"),
					"Romance", false);
			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("12/12/2019"), "Science Fiction", true);
			Movies itemFive = new Movies(5L, "Avengers:End Game", 2750760348L, true,
					new DateUtil().convertToDate("02/12/2022"), "Superhero", true);
			moviesList.add(itemOne);
			moviesList.add(itemTwo);
			moviesList.add(itemThree);
			moviesList.add(itemFour);
			moviesList.add(itemFive);
		}
	}

	@Override
	public List<Movies> getMoviesListAdmin() {
		return moviesList;
	}

	@Override
	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		for (Movies movies : moviesList) {
			if (movies.getDateOfLaunch().before(new Date())) {
				if (movies.getActive()) {
					filteredMovies.add(movies);
				}
			}
		}
		return filteredMovies;
	}

	@Override
	public void modifyMovies(Movies movies) {
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == movies.getId()) {
				moviesList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getMovies(Long moviesId) {
		for (Movies movies : moviesList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}

}
