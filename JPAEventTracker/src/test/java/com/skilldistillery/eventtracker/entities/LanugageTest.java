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

class LanugageTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Language lang;

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
		lang = em.find(Language.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		lang = null;
		em.close();
	}
	@DisplayName("Testing Language Entity Mapping")
	@Test
	public void test1() {
		assertEquals("Java",lang.getName());
		assertEquals("1995",lang.getCreationYear());
		assertEquals("Java is a programming language and computing platform first released by Sun Microsystems in 1995."
				+ " There are lots of applications and websites that will not work unless you have Java installed,"
				+ " and more are created every day. Java is fast, secure, and reliable. From laptops to datacenters, "
				+ "game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere!",lang.getDescription());
		assertEquals(2,lang.getLibraries().size());
	}
}
