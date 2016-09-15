package io.egen.app.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "UserComments.findById", query = "Select u from UserComments u where u.imdbId=:pid order by u.commentedOn desc"),
		}
)
public class UserComments {
	@Id
	private String commentId;
	private String commentedBy;	
	private String Comments;
	private String imdbId;
    private Date commentedOn;

    
    public UserComments(){
    	commentId= UUID.randomUUID().toString();
    }
    protected void onCreate() {
    	commentedOn = new Date();
    }

    public Date getCreated() {
		return commentedOn;
	}

	public void setCreated(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	
	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}


	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
}