package io.egen.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table

@NamedQueries({
	@NamedQuery(name="Movie.findAll", 			query="SELECT m from Movie m "),
	@NamedQuery(name="Movie.SearchTitleById", 	query="Select m from Movie m where m.imdbId = :pid"),
	@NamedQuery(name="Movie.SearchTitle", 		query="Select m from Movie m where m.title LIKE '%:ptitle%' "),
	@NamedQuery(name="Movie.SortByImdbRating",  query="SELECT m from Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name="Movie.SortByImdbVotes",   query="Select m from Movie m Order BY m.imdbVotes DESC"),
	@NamedQuery(name="Movie.SortByYear",        query="Select m from Movie m Order By m.year"),
	@NamedQuery(name="Movie.FilterByYear",      query="Select m from Movie m where m.year= :pyear"),
	@NamedQuery(name="Movie.FilterByGenre",     query="Select m from Movie m where m.genre LIKE '%:pgenre%' "),
	@NamedQuery(name="Movie.FilterByType",      query="Select m from Movie m where m.type= :ptype"),
	@NamedQuery(name="Movie.TopRated",    		query="Select m from Movie m where m.type= :ptype order by m.imdbRating DESC"),
	@NamedQuery(name="Movie.SeeDetails",        query="Select m.imdbRating, m.director, m.actor, m.plot from Movie m where m.title=:ptitle")
	
	
})
public class Movie {

	@Id
	@Column(unique=true)
	private String imdbId;
	@Column(length=512)
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	
	@Column(length=512)
	private String director;
	@Column(length=512)
	private String writer;
	@Column(length=512)
	private String actor;
	@Column (length=512)
	private String plot;
	private String language;
	@Column (length= 512)
	private String country;
	private String awards;
	private String poster;
	
	private int metascore;
	@Column (precision=1)
	private float imdbRating;
	private long imdbVotes;
	private String type;
	
	
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public long getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Movie [imdbId=" + imdbId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actor=" + actor + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", type=" + type + "]";
	}
	
	

	
	
	
}

