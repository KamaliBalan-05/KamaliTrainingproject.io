package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	@SuppressWarnings("unchecked")
	public static void testAddFavoritesMovies() throws FavoritesEmptyException {
		FavoritesDao FavoritesDao = new FavoritesDaoCollectionImpl();
		FavoritesDao.addFavoriteMovies(1, 2L);
		FavoritesDao.addFavoriteMovies(1, 5L);

		FavoritesDao.addFavoriteMovies(2, 1L);
		FavoritesDao.addFavoriteMovies(2, 3L);
		List<Movies> movieListCustomer = (List<Movies>) FavoritesDao.getAllFavoriteMovies(1);
		System.out.println("User Added Favorites List");
		for (Movies movies : movieListCustomer) {
			System.out.println(movies);
		}
		System.out.println("No.Of.Favorites :" + movieListCustomer.size());
	}

	@SuppressWarnings("unchecked")
	public static void testRemoveFavoritesMovies() throws FavoritesEmptyException {
		FavoritesDao FavoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Movies List for Customer after Remove");
		try {
			FavoritesDao.removeFavoriteMovies(1, 2L);
			// FavoritesDao.removeFavoritesMovies(1, 5L);
			FavoritesDao.removeFavoriteMovies(1, 3L);
			List<Movies> moviesListCustomer = (List<Movies>) FavoritesDao.getAllFavoriteMovies(1);

			for (Movies movies : moviesListCustomer) {
				System.out.println(movies);
			}
			System.out.println("No.Of.Favorites :" + moviesListCustomer.size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoritesMoviess() {
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovies();
		testRemoveFavoritesMovies();
	}

}
