package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites  {
	private List<Movies> moviesList;
	private int total;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> moviesList, int total) {
		super();
		this.moviesList = moviesList;
		this.total = total;
	}

	public List<Movies> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(List<Movies> moviesList) {
		this.moviesList = moviesList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moviesList == null) ? 0 : moviesList.hashCode());
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (moviesList == null) {
			if (other.moviesList != null)
				return false;
		} else if (!moviesList.equals(other.moviesList))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [moviesList=" + moviesList + ", total=" + total + "]";
	}


}
