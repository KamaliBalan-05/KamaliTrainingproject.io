package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavoritess;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavoritess == null) {
			userFavoritess = new HashMap<>();
		}
	}

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(moviesId);
		if (userFavoritess.containsKey(userId)) {
			userFavoritess.get(userId).getMoviesList().add(movies);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> moviesList = new ArrayList<>();
			moviesList.add(movies);
			favorites.setMoviesList(moviesList);
			userFavoritess.put(userId, favorites);
		}
	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Favorites favorites = userFavoritess.get(userId);
		int total = 0;
		if (favorites == null || favorites.getMoviesList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<Movies> moviesList = favorites.getMoviesList();
		total += moviesList.size();
		favorites.setTotal(total);
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {
		List<Movies> moviesList = userFavoritess.get(userId).getMoviesList();
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == moviesId) {
				moviesList.remove(i);
				return;
			}
		}
	}
}
