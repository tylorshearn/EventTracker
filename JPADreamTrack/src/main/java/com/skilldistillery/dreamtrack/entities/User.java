package com.skilldistillery.dreamtrack.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	@Column(name="profile_picture")
	private String profilePicture;
	
	@Column(name="dream_points")
	private Integer dreamPoints;
	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy="dream")
	private List<Dream> dreams;

	public User() {
		super();
	}

	public User(int id, String username, String password, String profilePicture, Integer dreamPoints,
			LocalDateTime createdOn, Boolean isActive, List<Dream> dreams) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.dreamPoints = dreamPoints;
		this.createdOn = createdOn;
		this.isActive = isActive;
		this.dreams = dreams;
	}
	
	public void addDream(Dream dream) {
		if(dreams == null) dreams = new ArrayList<>();
		
		if (!dreams.contains(dream)) {
			dreams.add(dream);
			if (dream.getUser() != null) {
				dream.getUser().getDreams().remove(dream);
			}
			dream.setUser(this);
		}
	}
	
	public void removeDream(Dream dream) {
		dream.setUser(null);
		if (dreams != null) {
			dreams.remove(dream);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Integer getDreamPoints() {
		return dreamPoints;
	}

	public void setDreamPoints(Integer dreamPoints) {
		this.dreamPoints = dreamPoints;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Dream> getDreams() {
		return dreams;
	}

	public void setDreams(List<Dream> dreams) {
		this.dreams = dreams;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profilePicture="
				+ profilePicture + ", dreamPoints=" + dreamPoints + ", createdOn=" + createdOn + ", isActive="
				+ isActive + ", dreams=" + dreams + "]";
	}
}
