package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibraryTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Library lib;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    emf = Persistence.createEntityManagerFactory("eventPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		lib = em.find(Library.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		lib = null;
		em.close();
	}
	@DisplayName("Testing Library Entity Mapping")
	@Test
	public void test1() {
		assertEquals("java.util",lib.getName());
	}
}
