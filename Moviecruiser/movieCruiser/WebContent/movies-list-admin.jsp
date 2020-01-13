<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies List Admin</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie-logo.jpg"> <a href="ShowMoviesListAdmin">Movies</a>
	</div>
	<h1>Movies</h1>
	<table>
		<tr style="width: 60%">
			<th id="titlesize">Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${moviesList}" var="movies">
			<tr style="text-align: center">
				<td id="titlesize">${movies.title}</td>
				<td><fmt:formatNumber type="currency" value='${movies.gross}'
						pattern="$###.###" /></td>
				<td><c:if test="${movies.active}">Yes</c:if> <c:if
						test="${!movies.active}">No</c:if></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${movies.dateOfLaunch}" /></td>
				<td>${movies. genre}</td>
				<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
						test="${!movies.hasTeaser}">No</c:if></td>
				<td><a href="ShowEditMovies?id=${movies.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>