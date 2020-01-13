package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIES_TO_FAVORITES = "insert into favorites (fs_us_id,fs_mo_id) values (?,?)";
	public static final String GET_FAVORITES_MOVIES = "select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from movies inner join favorites on fs_mo_id = mo_id where fs_us_id=?";
	public static final String GET_NO_OF_FAVORITES = "select count(mo_id) as No_of_Favorites from movies inner join favorites on fs_mo_id = mo_id where fs_us_id=?";
	public static final String DELETE_FAVORITES = "delete from favorites where fs_us_id=? and fs_mo_id=? limit 1";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("Insert done");
			} else {
				System.out.println("No insert");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementFavorites = null;
		ArrayList<Movies> moviesList = new ArrayList<>();
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_FAVORITES_MOVIES);
			preparedStatement.setLong(1, userId);
			resultSetList = preparedStatement.executeQuery();
			preparedStatementFavorites = connection.prepareStatement(GET_NO_OF_FAVORITES);
			preparedStatementFavorites.setLong(1, userId);
			resultSetTotal = preparedStatementFavorites.executeQuery();
			while (resultSetList.next()) {

				movies = new Movies();
				movies.setId(resultSetList.getLong("mo_id"));
				movies.setTitle(resultSetList.getString("mo_title"));
				movies.setGross(resultSetList.getLong("mo_box_office"));
				movies.setActive(resultSetList.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSetList.getDate("mo_date_of_launch"));
				movies.setGenre(resultSetList.getString("mo_genre"));
				movies.setHasTeaser(resultSetList.getString("mo_has_teaser").equals("Yes"));
				moviesList.add(movies);
			}
			while (resultSetTotal.next()) {
				favorites.setTotal(resultSetTotal.getInt("No_of_Favorites"));
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorites.setMoviesList(moviesList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetList != null)
					resultSetList.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (preparedStatementFavorites != null)
					preparedStatementFavorites.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("No of rows affected " + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}