package io.egen.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "TitleDetails.findById", query = "Select u from TitleDetails u where u.imdbid=:pid"),
		}
)
public class TitleDetails {
	
	@Id
	@Column(unique=true)
	private String imdbId;
	private String Director;
	private String Actors;
	private String Plot;
	private String imdbRating;
	

	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

}