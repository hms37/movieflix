package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.egen.app.entity.Movie;
import io.egen.app.entity.TitleDetails;
import io.egen.app.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService service;


	@RequestMapping(method=RequestMethod.GET,value="/movies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/movies/{imdbId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("imdbId") String movieId){
		return service.findOne(movieId);
	}
	//sorts
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/sortbyvotes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbVotes(){
		return service.sortTitles("votes");
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/sortbyyear", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortTitlesByYear(){
		return service.sortTitles("year");
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/sortbyrating",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortTitlesByImdbRating(){
		return service.sortTitles("rating");
	}
	
	//filters
	
	@RequestMapping(method=RequestMethod.GET, value="/movies/filter/type={type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> filterByType(@PathVariable("type") String type){
		return service.filterByType(type);
	}

	@RequestMapping(method=RequestMethod.GET, value="/movies/filter/year={year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> filterByYear(@PathVariable("year") String year){
		return service.filterByYear(year);
	}

	
	@RequestMapping(method=RequestMethod.GET, value="/movies/filter/genre={genre}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> filterByGenre(@PathVariable("genre") String genre){
		return service.filterByGenre(genre);
	}
	

		
	@RequestMapping(method=RequestMethod.GET, value="/movies/search={search}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> search(@PathVariable("search") String keyword){
			return service.search(keyword);
		}

	@RequestMapping(method=RequestMethod.GET, value="/movies/{imdbId}/getDetails",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TitleDetails getTitleDetails(@PathVariable("imdbId") String movieId){
		return service.getTitleDetails(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/movies/{imdbId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("imdbId") String movieId, @RequestBody Movie movie){
		return service.update(movieId, movie);
	}
	

	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{imdbId}")
	public void delete(@PathVariable("imdbId") String movieId){
		service.delete(movieId);
	}

}