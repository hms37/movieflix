package io.egen.app.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Movie;
import io.egen.app.entity.TitleDetails;
import io.egen.app.entity.UserComments;
import io.egen.app.entity.UserRating;
import io.egen.app.exception.EntityAlreadyExistException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.MovieRepository;

@Service
@Transactional(readOnly=false)
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository repository;
	@Override
	public List<Movie> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Movie findOne(String movieId) {
		
		Movie existing = repository.findOne(movieId);
		if(existing == null)
			return null;
		return existing;
	}

	
	@Override
	public Movie create(Movie movie) {
	
		Movie existing = repository.findOne(movie.getImdbId());		
		if(existing != null)
			throw new EntityAlreadyExistException("Title with ID: "+movie.getImdbId()+" already exists");
		return repository.create(movie);
	}

	
	@Override
	public Movie update(String movieId, Movie movie) {
		
		Movie existing = repository.findOne(movieId);
		if(existing == null)
			throw new EntityNotFoundException("Title doesn't exist");
		return repository.update(movie);	
	}


	@Override
	public void delete(String movieId) {
		
		Movie existing = repository.findOne(movieId);
		if(existing == null)
			throw new EntityNotFoundException("No title with ID- "+movieId+" found in the detabase");
		repository.delete(existing);
	}

	@Override
	public List<Movie> sortTitles(String string) {
		System.out.println("String in Service class is: "+string);
		return repository.sortTitles(string);
	}

	@Override
	public List<Movie> filterByType(String type) {	
		return repository.filterByType(type);
	}

	@Override
	public List<Movie> filterByYear(String year) {
		return repository.filterByYear(year);
	}

	@Override
	public List<Movie> filterByGenre(String genre) {
		return repository.filterByGenre(genre);
	}


	@Override
	public List<Movie> search(String keyword) {
		List<Movie> existing = repository.search(keyword);
		if(existing == null)
			throw new EntityNotFoundException("No title with keyword- "+keyword+"found");
		return existing;
	}

	@Override
	public UserRating rateTitle(UserRating rating) {
		Movie existing = repository.findOne(rating.getImdbId());
		if(existing == null){
			String error = "No title with ID: "+rating.getImdbId()+" found";
			throw new EntityNotFoundException(error);
		}
		if(rating.getRating() == null)
			throw new EntityNotFoundException("Rating cannot be null and must be between 1 and 5");
		
		Double rate = Double.parseDouble(rating.getRating());
		System.out.println("User rating is: "+rate);
		if(rate < 1.0 || rate > 5.0)
			throw new EntityNotFoundException("Rating cannot be null and must be between 1 and 5");
		return repository.rateTitle(rating);
	}

	@Override
	public String viewRatingOnTitle(String movieId) {
		Movie existing = repository.findOne(movieId);
		if(existing == null){
			String error = "No title with ID: "+movieId+" found";
			throw new EntityNotFoundException(error);
		}
		Double rating = repository.viewRatingOnTitle(movieId);
		
		DecimalFormat two = new DecimalFormat("#0.00");
		String finalRating = "Average User Rating of "+existing.getTitle()+": "+two.format(rating)+"/5" ; 
		return finalRating;
	}

	@Override
	public List<Movie> viewTopRated(String type) {
		return repository.getTopTitles(type);
	}

	@Override
	public UserComments commentOnTitle(UserComments comment) {
		
		Movie existing = repository.findOne(comment.getImdbId());
		if(existing == null)
			throw new EntityNotFoundException("No title with ID- "+comment.getImdbId()+"found");
		return repository.commentOnTitle(comment);
	}

	@Override
	public List<UserComments> viewCommentOnTitle(String movieId) {
		Movie existing = repository.findOne(movieId);
		if(existing == null){
			String error = "No title with ID: "+movieId+" found";
			throw new EntityNotFoundException(error);
		}
		return repository.viewCommentOnTitle(movieId);
	}

	@Override
	public TitleDetails getTitleDetails(String movieId) {
		TitleDetails existing = repository.getTitleDetails(movieId);
		if(existing == null)
			throw new EntityNotFoundException("No title with ID- "+movieId+"found");
		return existing;
	}

}
