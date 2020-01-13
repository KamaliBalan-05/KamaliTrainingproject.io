package com.cognizant.moviecruiser.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoriteMovies() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		favoritesDao.addFavoriteMovies(1L, 2);
		System.out.println("Done");
	}

	public static void testGetAllFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = favoritesDaoSqlImpl.getAllFavoriteMovies(1L);
		System.out.println(favorites.getMoviesList());
		System.out.println(favorites.getTotal());
		System.out.println("Done");
	}

	public static void testRemoveFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter movies id");
		long moviesId = Long.parseLong(bf.readLine());

		new FavoritesDaoSqlImpl().removeFavoriteMovies(userId, moviesId);
	}

	public static void main(String[] args) throws FavoritesEmptyException, NumberFormatException, IOException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
		testGetAllFavoriteMovies();
	}

}
