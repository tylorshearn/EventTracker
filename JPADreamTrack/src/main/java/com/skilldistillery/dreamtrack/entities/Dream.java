package com.skilldistillery.dreamtrack.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Dream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min=7, max=65535, message="Title must be longer than 6 characters.")
	private String title;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="is_complete")
	private Boolean isComplete;
	
	@Column(name="started_on")
	private LocalDateTime startedOn;
	
	@Size(min=0, max=65535)
	private String description;
	
	@Size(min=0, max=2147483647, message="This must be a huge accomplishment! Try reducing the points you're awarding yourself.")
	@Column(name="points_rewarded")
	private Integer pointsRewarded;
	
	@Column(name = "finished_on")
	private LocalDateTime finishedOn;
	
	@Pattern(regexp="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]" +
	"|1[0-2])\\\\2))(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)0?2\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)?(" + 
	"?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:" + 
	"0?[1-9])|(?:1[0-2]))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$", message="Date must be in dd/mm/yyyy, dd-mm-yyyy, or dd.mm.yyyy format.")
	@Column(name="goal_date")
	private String goalDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="dream")
	private List<Track> tracks;
	
	public Dream() {
		super();
	}

	public Dream(int id, String title, Boolean isActive, Boolean isComplete, LocalDateTime startedOn,
			String description, Integer pointsRewarded, LocalDateTime finishedOn, String goalDate, User user,
			List<Track> tracks) {
		super();
		this.id = id;
		this.title = title;
		this.isActive = isActive;
		this.isComplete = isComplete;
		this.startedOn = startedOn;
		this.description = description;
		this.pointsRewarded = pointsRewarded;
		this.finishedOn = finishedOn;
		this.goalDate = goalDate;
		this.user = user;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if(tracks == null) tracks = new ArrayList<>();
		
		if (!tracks.contains(track)) {
			tracks.add(track);
			if (track.getDream() != null) {
				track.getDream().getTracks().remove(track);
			}
			track.setDream(this);
		}
	}
	
	public void removeTrack(Track track) {
		track.setDream(null);
		if (tracks != null) {
			tracks.remove(track);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public LocalDateTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPointsRewarded() {
		return pointsRewarded;
	}

	public void setPointsRewarded(Integer pointsRewarded) {
		this.pointsRewarded = pointsRewarded;
	}

	public LocalDateTime getFinishedOn() {
		return finishedOn;
	}

	public void setFinishedOn(LocalDateTime finishedOn) {
		this.finishedOn = finishedOn;
	}

	public String getGoalDate() {
		return goalDate;
	}

	public void setGoalDate(String goalDate) {
		this.goalDate = goalDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dream other = (Dream) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dream [id=" + id + ", title=" + title + ", isActive=" + isActive + ", isComplete=" + isComplete
				+ ", startedOn=" + startedOn + ", description=" + description + ", pointsRewarded=" + pointsRewarded
				+ ", finishedOn=" + finishedOn + ", goalDate=" + goalDate + ", user=" + user + ", tracks=" + tracks
				+ "]";
	}
}
