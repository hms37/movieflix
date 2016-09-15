package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.UserComments;
import io.egen.app.service.MovieService;

@RestController
@RequestMapping(value="/movies")
public class UserCommentsController {
	@Autowired 
	private MovieService service;

		@RequestMapping(method=RequestMethod.POST, value="/postComment",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public UserComments commentOnTitle(@RequestBody UserComments comment){
			return service.commentOnTitle(comment);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/{imdbId}/viewComments",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<UserComments> viewCommentOnTitle(@PathVariable("id") String movieId){
			return service.viewCommentOnTitle(movieId);
		}

}