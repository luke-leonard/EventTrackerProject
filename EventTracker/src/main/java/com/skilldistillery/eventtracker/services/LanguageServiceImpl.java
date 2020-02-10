package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Language;
import com.skilldistillery.eventtracker.repositories.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageRepository langRepo;

	@Override
	public List<Language> getLanguages() {
		return langRepo.findAll();
	}

	@Override
	public Language getLanguage(Integer id) {
		Optional<Language> opt = langRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;			
		}
	}

	@Override
	public Language createLanguage(Language language) {
		language.setId(0);
		try {
		language = langRepo.saveAndFlush(language);
		return language;
		}catch(Exception e) {
			return null;			
		}
	}

	@Override
	public Language updateLanguage(Language language) {
		Optional<Language> opt = langRepo.findById(language.getId());
		if(opt.isPresent()) {
			language = langRepo.saveAndFlush(language);
			return language;
		}else {
			return null;			
		}
	}

	@Override
	public Boolean deleteLanguage(Integer id) {
		Optional<Language> opt = langRepo.findById(id);
		if(opt.isPresent()) {
			try {
			langRepo.deleteById(id);
			}catch(Exception e) {
				return null;
			}
			opt = langRepo.findById(id);
			if(!opt.isPresent()) {
				return true;
			}else {
				return null;
			}
		}else {
			return false;			
		}
	}
	
	
}
