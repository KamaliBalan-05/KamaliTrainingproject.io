package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoriteMovies(long userId, long moviesId);

	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoriteMovies(long userId, long moviesId);

}
