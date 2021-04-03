package com.skilldistillery.dreamtrack.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min=5, max=45, message="Title must be longer than 4 characters.")
	private String title;
	
	@NotBlank
	@Size(min=10, max=65535, message="Description must be longer than 9 characters.")
	private String description;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="started_on")
	private LocalDateTime startedOn;
	
	@Column(name="finished_on")
	private LocalDateTime finishedOn;
	
	@Column(name="is_complete")
	private Boolean isComplete;
	
	@ManyToOne
	@JoinColumn(name="dream_id")
	private Dream dream;

	public Track() {
		super();
	}

	public Track(int id, String title, String description, Boolean isActive, LocalDateTime startedOn, LocalDateTime finishedOn,
			Boolean isComplete, Dream dream) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.isActive = isActive;
		this.startedOn = startedOn;
		this.finishedOn = finishedOn;
		this.isComplete = isComplete;
		this.dream = dream;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}

	public LocalDateTime getFinishedOn() {
		return finishedOn;
	}

	public void setFinishedOn(LocalDateTime finishedOn) {
		this.finishedOn = finishedOn;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Dream getDream() {
		return dream;
	}

	public void setDream(Dream dream) {
		this.dream = dream;
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
		Track other = (Track) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", title=" + title + ", description=" + description + ", isActive=" + isActive
				+ ", startedOn=" + startedOn + ", finishedOn=" + finishedOn + ", isComplete=" + isComplete + ", dream="
				+ dream + "]";
	}
}
