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

class DreamTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Dream dream;

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
		dream = em.find(Dream.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dream = null;
	}

	@Test
	@DisplayName("Dream Mapping")
	void test() {
		assertNotNull(dream);
		assertEquals("Make $100 Trading Stocks This Week", dream.getTitle());
	}
	
	@Test
	@DisplayName("Dream-Track Mapping")
	void test2() {
		assertNotNull(dream);
		assertEquals("Buy Shares", dream.getTracks().get(0).getDescription());
	}
}
