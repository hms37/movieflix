package io.egen.app.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "UserRating.findAvgRatingByTitleID", query = "SELECT AVG(u.Rating) FROM UserRating u WHERE u.imdbId =:pid"),
		}
)
public class UserRating {

	@Id
	private String ratingid;
	private String ratedBy;
	private String Rating;
	private String imdbId;
	
	public UserRating(){
		
		ratingid= UUID.randomUUID().toString();
		
	}
	
	 @Column(name = "RatedOn", updatable=true)
	    private Date ratedOn;
	 
	 @PrePersist
	    protected void onCreate() {
	    	ratedOn = new Date();
	    }
	 
	 public Date getCreated() {
			return ratedOn;
		}

		public void setCreated(Date ratedOn) {
			this.ratedOn = ratedOn;
		}

	    public String getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	

		

}
