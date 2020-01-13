package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MoviesDao;
import com.cognizant.moviecruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMoviesServlet
 */
@WebServlet("/EditMovies")
public class EditMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMoviesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("yes");
		Date dateOfLaunch;
		dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		Movies movies = new Movies(id, title, gross, active, dateOfLaunch, genre, hasTeaser);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.modifyMovies(movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movies-status.jsp");
		dispatcher.forward(request, response);
	}

}
