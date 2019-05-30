package com.hibernate.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPersonne {
	
	private Inscriptions inscr = Inscriptions.getInscriptions();
	private Personne personne;

	
	@Before // avec cette annotation, cette m�thode sera appel�e avant chaque test
	public void setUp() throws Exception {
		 personne = inscr.createPersonne("Mlaghui", "Brahim", "bra@gmail.com");
	}
	
	@Test
	public void testGetPrenom() {
		assertEquals("Brahim", personne.getPrenom());	
	}
	
	@Test
	public void testSetPrenom() {
		personne.setPrenom("Dany");
		assertEquals("Dany", personne.getPrenom());
	}
	
	@Test
	public void testSetNom() {
		personne.setNom("Boon");
		assertEquals("Boon", personne.getNom());
	}

	@Test
	public void testGetNom() {
		assertTrue(personne.getNom(), personne.getNom().equals("Mlaghui"));
	}
	
	@Test
	public void testSetMail() {
		personne.setMail("danyboon@gmail.com");
		assertEquals("danyboon@gmail.com", personne.getMail());
	}
	
	@Test
	public void testGetMail() {
		assertTrue(personne.getMail(), personne.getMail().equals("bra@gmail.com"));
	}
	
	@Test
	public void testGetEquipe() {
		Equipe equipe1 = inscr.createEquipe("Equipe de Poker");
		assertTrue(equipe1.add(personne));
		Set<Equipe> setEquipe1 = personne.getEquipes();
		assertTrue(setEquipe1.contains(equipe1));
	}
	@Test
	public void testGetPersonneEquipe() {
		Equipe equipe1 = inscr.createEquipe("Equipe de Poker");
		assertTrue(equipe1.add(personne));
		Set<Equipe> setEquipe1 = personne.getEquipes();
		personne.delete();
		assertFalse(setEquipe1.contains(equipe1));
	}

}