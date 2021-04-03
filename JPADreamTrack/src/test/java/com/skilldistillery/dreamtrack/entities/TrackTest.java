package com.skilldistillery.dreamtrack.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Track track;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("DreamTrackPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		track = em.find(Track.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		track = null;
	}

	@Test
	@DisplayName("Track Mapping")
	void test() {
		assertNotNull(track);
		assertEquals("Buy Stock", track.getTitle());
	}
	
	@Test
	@DisplayName("Track-Dream Mapping")
	void test2() {
		assertNotNull(track);
		assertEquals("Make $100 Trading Stocks This Week", track.getDream().getTitle());
	}
}