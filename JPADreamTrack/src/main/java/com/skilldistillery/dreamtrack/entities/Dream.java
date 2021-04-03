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

@Entity
public class Dream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="is_complete")
	private Boolean isComplete;
	
	@Column(name="started_on")
	private LocalDateTime startedOn;
	
	private String description;
	
	@Column(name="points_rewarded")
	private Integer pointsRewarded;
	
	@Column(name = "finished_on")
	private LocalDateTime finishedOn;
	
	@Column(name="goal_date")
	private LocalDateTime goalDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="dream")
	private List<Track> tracks;
	
	public Dream() {
		super();
	}

	public Dream(int id, String title, Boolean isActive, Boolean isComplete, LocalDateTime startedOn,
			String description, Integer pointsRewarded, LocalDateTime finishedOn, LocalDateTime goalDate, User user,
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

	public LocalDateTime getGoalDate() {
		return goalDate;
	}

	public void setGoalDate(LocalDateTime goalDate) {
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
