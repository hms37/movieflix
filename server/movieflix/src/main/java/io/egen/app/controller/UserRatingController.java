package io.egen.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Movie;
import io.egen.app.entity.UserRating;
import io.egen.app.service.MovieService;

@RestController
@RequestMapping(value="/movies")
public class UserRatingController {

	@Autowired
	private MovieService service;

		@RequestMapping(method=RequestMethod.POST, value="/postRating",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public UserRating rateTitle(@RequestBody UserRating rating){
			return service.rateTitle(rating);
		}
		
	
		@RequestMapping(method=RequestMethod.GET, value="/{imdbId}/viewRating",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String viewRatingOnTitle(@PathVariable("id") String movieID){
			return service.viewRatingOnTitle(movieID);
		}
		
	
		@RequestMapping(method=RequestMethod.GET, value="/top={type}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> viewTopRated(@PathVariable("type") String type){
			return service.viewTopRated(type);
		}
		
}