package com.skilldistillery.eventtracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Library {
	
	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "documentation_url")
	private String documentaionUrl;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	// C O N S T U C T O R S
	public Library(Integer id, String name, String documentaionUrl, Language language) {
		super();
		this.id = id;
		this.name = name;
		this.documentaionUrl = documentaionUrl;
		this.language = language;
	}
	
	public Library() {
		super();
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

	public String getDocumentaionUrl() {
		return documentaionUrl;
	}

	public void setDocumentaionUrl(String documentaionUrl) {
		this.documentaionUrl = documentaionUrl;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	// A U T O - G E N _ M E T H O D S
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentaionUrl == null) ? 0 : documentaionUrl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		Library other = (Library) obj;
		if (documentaionUrl == null) {
			if (other.documentaionUrl != null)
				return false;
		} else if (!documentaionUrl.equals(other.documentaionUrl))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
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
		return "Library [id=" + id + ", name=" + name + ", documentaionUrl=" + documentaionUrl + ", language="
				+ language + "]";
	}
	
	
	
}
