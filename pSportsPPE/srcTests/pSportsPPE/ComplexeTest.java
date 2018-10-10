package pSportsPPE;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.rigaud.Arrivee;
import fr.rigaud.Complexe;

public class ComplexeTest {
	
	private Complexe leComplexe;
	private Arrivee lArrivee;
	private ArrayList<Arrivee> lesArrivees;

	@Before
	public void setUp() throws Exception {
		final int NBTOTALPLACEMUSCU = 4;
		final int NBTOTALPLACEFIT = 5;
		final char CHOIXSPORT = 'M';
		
		leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT, "leComplexe");
		lArrivee = new Arrivee(leComplexe, CHOIXSPORT);
		List<Arrivee> lesArrivees = new ArrayList<Arrivee>();
		
	}

	@Test
	public void testConstructeur() {
		final int NBTOTALPLACEMUSCU = 4;
		final int NBTOTALPLACEFIT = 5;
		Complexe leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT , "leComplexe");
		assertEquals("leComplexe", leComplexe.getNomComplexe());
	}
	
	@Test
	public void testEntreeUsager() {
		assertEquals(true, leComplexe.entreeUsager(lArrivee));
	}
	
	@Test
	public void testSortieUsager() {
		assertEquals(true, leComplexe.entreeUsager(lArrivee));
		assertEquals(lArrivee, leComplexe.sortieUsager(1));
	}
	
	@Test
	public void testPlace() {
		assertEquals(0, leComplexe.getNbPlacesOccupeesFit());
		assertEquals(0, leComplexe.getNbPlacesOccupeesMuscu());
		assertEquals(5, leComplexe.getNbPlacesRestantesFit());
		assertEquals(4, leComplexe.getNbPlacesRestantesMuscu());
	}
}


