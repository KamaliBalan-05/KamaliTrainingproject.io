package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Item List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Item List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "Charlie", 5755683686L, true, new DateUtil().convertToDate("02/11/2022"),
				"Dessert", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("*** Modified Menu Item List ***");
		testGetMoviesListAdmin();
		Movies modified_item = moviesDao.getMovies(item.getId());
		System.out.println("Modified ITEM Details\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}

}
