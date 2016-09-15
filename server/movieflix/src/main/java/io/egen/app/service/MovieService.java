package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Movie;
import io.egen.app.entity.TitleDetails;
import io.egen.app.entity.UserComments;
import io.egen.app.entity.UserRating;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void delete(String movieId);

	public List<Movie> sortTitles(String string);
	
	public List<Movie> filterByType(String type);

	public List<Movie> filterByYear(String year);

	public List<Movie> filterByGenre(String genre);

	public List<Movie> search(String keyword);

	public UserRating rateTitle(UserRating rating);

	public String viewRatingOnTitle(String movieId);

	public List<Movie> viewTopRated(String type);

	public UserComments commentOnTitle(UserComments comment);

	public List<UserComments> viewCommentOnTitle(String movieId);
	
	public TitleDetails getTitleDetails(String id);

	

}
