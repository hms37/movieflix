package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Movie;
import io.egen.app.entity.TitleDetails;
import io.egen.app.entity.UserComments;
import io.egen.app.entity.UserRating;

@Repository
public class MovieRepositoryImp implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
		
	}

	@Override
	public void delete(Movie existing) {
		em.remove(existing)	;
		
	}

	@Override
	public List<Movie> sortTitles(String string) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> filterByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FilterByType", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> filterByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FilterByGenre", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> filterByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FilterByYear", Movie.class);
		return query.getResultList();
	}
	

	@Override
	public List<Movie> search(String keyword) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.SearchTitle", Movie.class);
		query.setParameter("ptitle", "%"+keyword+"%");
		List<Movie> titles = query.getResultList();
		if(titles != null)
			return titles;
		return null;
	}

	@Override
	public UserRating rateTitle(UserRating rating) {
		rating.setRatedBy("User authentication yet to be implemented");
		em.persist(rating);	
		return rating;
	}
	
	@Override
	public Double viewRatingOnTitle(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("UserRating.findAvgRatingByTitleID", Double.class); 
		query.setParameter("pid", movieId);
		Double rating = query.getSingleResult();
		if(rating != null)
			return rating;
		return null;
	}

	@Override
	public List<Movie> getTopTitles(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.TopRated", Movie.class); 
		query.setParameter("ptype", type);
		query.setMaxResults(50);
		return query.getResultList();
	}

	@Override
	public UserComments commentOnTitle(UserComments comment) {
		comment.setCommentedBy("User authentication yet to be implemented");
		em.persist(comment);
		return comment;
	}

	@Override
	public List<UserComments> viewCommentOnTitle(String movieId) {
		TypedQuery<UserComments> query = em.createNamedQuery("UserComments.findById", UserComments.class); 
		query.setParameter("pID", movieId);
		List<UserComments> comments = query.getResultList();
		if(comments != null)
			return comments;
		return null;
	}

	@Override
	public TitleDetails getTitleDetails(String movieId) {
		return em.find(TitleDetails.class, movieId);
	}

	

}
