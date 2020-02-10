package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Language;

public interface LanguageService {

	List<Language> getLanguages();
	Language getLanguage(Integer id);
	Language createLanguage(Language language);
	Language updateLanguage(Language language);
	Boolean deleteLanguage(Integer id);

}
