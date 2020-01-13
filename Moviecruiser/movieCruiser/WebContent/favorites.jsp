<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie-logo.jpg"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<div class="page-title">Favorites</div>
	<c:if test="${deleteFavoritesStatus}">
		<div class="success-message">Movie removed from Favorites
			Successfully</div>
	</c:if>

	<table>
		<tr style="width: 60%">
			<th id="titlesize">Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${favorites.moviesList}" var="movies">
			<tr style="text-align: center">
				<td id="titlesize">${movies.title}</td>
				<td><fmt:formatNumber type="currency" value='${movies.gross}'
						pattern="$###.###" /></td>
				<td>${movies. genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>No. of Favorites</td>
			<td>${favorites.total}</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>