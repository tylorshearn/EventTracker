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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="dreamt_on")
	private LocalDateTime dreamtOn;
	
	@Size(min=0, max=65535)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String effect;
	
	private String kind;
	
	public Dream() {
		super();
	}

	public Dream(int id, String title, Boolean isActive, LocalDateTime dreamtOn, String description, User user,
			String effect, String kind) {
		super();
		this.id = id;
		this.title = title;
		this.isActive = isActive;
		this.dreamtOn = dreamtOn;
		this.description = description;
		this.user = user;
		this.effect = effect;
		this.kind = kind;
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

	public LocalDateTime getDreamtOn() {
		return dreamtOn;
	}

	public void setDreamtOn(LocalDateTime dreamtOn) {
		this.dreamtOn = dreamtOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
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
		return "Dream [id=" + id + ", title=" + title + ", isActive=" + isActive + ", dreamtOn=" + dreamtOn
				+ ", description=" + description + ", user=" + user + ", effect=" + effect + ", kind=" + kind + "]";
	}

}
