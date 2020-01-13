package com.cognizant.moviecruiser.dao;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testgetMoviesListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Title", "BoxOffice", "Active",
				"Date of Launch", "Genre", "Has Teaser");
		String active;
		String hasTeaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getHasTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
		}
	}

	public static void testGetMoviesListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Title", "BoxOffice", "Active",
				"Date of Launch", "Genre", "Has teaser");
		String active;
		String hasTeaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getHasTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
		}
	}

	public static void testModifyMovies() throws NumberFormatException, IOException {
		Movies movies = new Movies(1L, "Theri", 12345678, true, new DateUtil().convertToDate("12/12/2019"), "Action",
				true);

		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();

		moviesDaoSqlImpl.modifyMovies(movies);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		testgetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
		testgetMoviesListAdmin();
	}

}
