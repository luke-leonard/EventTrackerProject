package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
