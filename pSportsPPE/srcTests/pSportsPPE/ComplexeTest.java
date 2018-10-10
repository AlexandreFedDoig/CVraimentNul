package pSportsPPE;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.rigaud.Arrivee;
import fr.rigaud.ChoixCouleur;
import fr.rigaud.Complexe;

public class ComplexeTest {
	
	private Complexe leComplexe;
	private Arrivee lArrivee;
	private Arrivee lArrivee2;
	private ArrayList<Arrivee> lesArrivees;

	@Before
	public void setUp() {
		final int NBTOTALPLACEMUSCU = 4;
		final int NBTOTALPLACEFIT = 5;
		final char MUSCU = 'M';
		final char FIT = 'F';
		
		leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT, "leComplexe");
		lArrivee = new Arrivee(leComplexe, MUSCU);
		lArrivee2 = new Arrivee(leComplexe, FIT);
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
		assertEquals(true, leComplexe.entreeUsager(lArrivee2));
	}
	
	@Test
	public void testSortieUsager() {
		assertEquals(true, leComplexe.entreeUsager(lArrivee));
		assertEquals(true, leComplexe.entreeUsager(lArrivee2));
		assertEquals(lArrivee, leComplexe.sortieUsager(1));
		assertEquals(lArrivee2, leComplexe.sortieUsager(2));
	}
	
	@Test
	public void testPlace() {
		assertEquals(0, leComplexe.getNbPlacesOccupeesFit());
		assertEquals(0, leComplexe.getNbPlacesOccupeesMuscu());
		assertEquals(5, leComplexe.getNbPlacesRestantesFit());
		assertEquals(4, leComplexe.getNbPlacesRestantesMuscu());
	}
	
	@Test
	public void testInfos() {
		final String MSGNOM = "Etat du complexe : ";
		final String MSGDATE = "date : ";
		final String MSGHEURE = "heure : ";
		final String MSGDISPMUSCU = "Places disponibles M : ";
		final String MSGDISPFIT = "Places disponibles F : ";
		final String MSGOCCMUSCU = "Places occupées M : ";
		final String MSGOCCFIT = "Places occupées F : ";
		final String MSGTXMUSCU = "Taux occ. M : ";
		final String MSGTXFIT = "Taux occ. F : ";
		final String MSGCOULMUSCU = "Couleur M : ";
		final String MSGCOULFIT = "Couleur F : ";
		final String MSGBAS = "M : en musculation	F : en fitness";
		
		String lesInfos;
		
		DecimalFormat df2 = new DecimalFormat("##0.00%");
		lesInfos = MSGNOM + "leComplexe" + "\t";
		
		Date laDate = Calendar.getInstance().getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		lesInfos += MSGDATE + leJour.format(laDate) + "\t";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		lesInfos += MSGHEURE + lHeure.format(laDate) + "\n";

		lesInfos += MSGDISPMUSCU + leComplexe.getNbPlacesRestantesMuscu() + "\t";
		lesInfos += MSGOCCMUSCU + leComplexe.getNbPlacesOccupeesMuscu() + "\t";
		lesInfos += MSGTXMUSCU + df2.format(leComplexe.etatMuscu()).toString() + "\t";
		ChoixCouleur choixCouleur = new ChoixCouleur(leComplexe.etatFit());
		lesInfos += MSGCOULMUSCU + (choixCouleur.getCouleur().toString()) + "\n";

		lesInfos += MSGDISPFIT + this.getNbPlacesRestantesFit() + "\t";
		lesInfos += MSGOCCFIT + this.nbPlacesOccupeesFit + "\t";
		lesInfos += MSGTXFIT + df2.format(this.etatFit()) + "\t";
		lesInfos += MSGCOULFIT + this.couleurFit() + "\n\n";
	}
}


