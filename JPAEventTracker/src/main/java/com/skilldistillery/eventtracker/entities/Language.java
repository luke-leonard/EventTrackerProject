package com.skilldistillery.eventtracker.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Language {
	
	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "creation_year")
	private String creationYear;

	@Column(name = "desciption")
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "language")
	private List<Library> libraries;

	// C O N S T R U C T O R S
	public Language() {
		super();
	}

	public Language(Integer id, String name, String creationYear, String description, List<Library> libraries) {
		super();
		this.id = id;
		this.name = name;
		this.creationYear = creationYear;
		this.description = description;
		this.libraries = libraries;
	}

	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(String creationYear) {
		this.creationYear = creationYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Library> getLibraries() {
		return libraries;
	}

	public void setLibraries(List<Library> libraries) {
		this.libraries = libraries;
	}

	// A U T O - G E N _ M E T H O D S 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationYear == null) ? 0 : creationYear.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libraries == null) ? 0 : libraries.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Language other = (Language) obj;
		if (creationYear == null) {
			if (other.creationYear != null)
				return false;
		} else if (!creationYear.equals(other.creationYear))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libraries == null) {
			if (other.libraries != null)
				return false;
		} else if (!libraries.equals(other.libraries))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", creationYear=" + creationYear + ", description="
				+ description + "]";
	}

}
