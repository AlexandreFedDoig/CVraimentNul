package pSportsPPE;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import fr.rigaud.Arrivee;
import fr.rigaud.Complexe;

public class ArriveeTest {

	private Complexe leComplexe;
	private Arrivee lArrivee;
	private long horaireArrivee;
	
	@Before
	public void setUp() {
		final int NBTOTALPLACEMUSCU = 4;
		final int NBTOTALPLACEFIT = 5;
		final char CHOIXSPORT = 'M';
		
		leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT, "leComplexe");
		lArrivee = new Arrivee(leComplexe, CHOIXSPORT);
		this.horaireArrivee = Calendar.getInstance().getTimeInMillis();
	}
	
	@Test
	public void testConstructeur() {
		final double DELTA = 0.1;
		
		assertEquals(leComplexe, lArrivee.getComplexe());
		assertEquals('M', lArrivee.getChoixSport());
		assertEquals(Calendar.getInstance().getTimeInMillis(), lArrivee.getHoraireArrivee(), DELTA);
		assertEquals(null, lArrivee.gethDep());
	}

	@Test
	public void testAfficheBillet() {
		final String MSGNOMCOMPLEXE = "Complexe ";
		final String MSGNUMBILLET = "Billet d'entrée n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String RC = "\n";
		
		String leBillet;
		
		Calendar leCal = Calendar.getInstance();
		leCal.setTimeInMillis(horaireArrivee);
		Date laDate = leCal.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		
		leBillet = MSGNOMCOMPLEXE + lArrivee.getComplexe().getNomComplexe() + "\t";
		leBillet += MSGNUMBILLET + lArrivee.getNumeroArrivee() + RC;
		leBillet += MSGDATE + leJour.format(laDate) + RC;
		leBillet += MSGHEURE + lHeure.format(laDate) + RC;
		
		assertEquals(leBillet, lArrivee.afficheBillet());
	}
	
	@Test
	public void testAfficheTicket() {
		final String MSGNOMCOMPLEXE = "Complexe ";
		final String MSGNUMTICKET = "Ticket de sortie n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String MSGMONTANT = "Montant : ";
		final String RC = "\n";
		
		String leTicket;
		Calendar heureDepart = Calendar.getInstance();
		
		Date laDate = heureDepart.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		
		leTicket = MSGNOMCOMPLEXE + lArrivee.getComplexe().getNomComplexe() + "\t";
		leTicket += MSGNUMTICKET + lArrivee.getNumeroArrivee()+1 + RC;
		leTicket += MSGDATE + leJour.format(laDate) + RC;
		leTicket += MSGHEURE + lHeure.format(laDate) + RC;
		leTicket += MSGMONTANT + lArrivee.getMontant() + "€" + RC;
		
		assertEquals(leTicket, lArrivee.afficheTicket());
	}
	
	@Test
	public void testGetMontant() {
		double cout = 0;
		final double DELTA = 1;
		
		//test avec l'heure de depart non instanciée
		assertEquals(cout, lArrivee.getMontant(), DELTA);
		
		//test avec l'heure instanciée avec rien
		Calendar heureDepart = Calendar.getInstance();
		assertEquals(cout, lArrivee.getMontant(), DELTA);
		
		//test avec 23 min de durée
		cout = 0.5;
		assertEquals(cout, lArrivee.getMontant(), DELTA);
	}
	
	@Test
	public void testGetters() {
		final double DELTA = 1;
		
		assertEquals(leComplexe, lArrivee.getComplexe());
		assertEquals('M', lArrivee.getChoixSport());
		assertEquals(Calendar.getInstance().getTimeInMillis(), lArrivee.getHoraireArrivee(), DELTA);
		assertEquals(null, lArrivee.gethDep());
		assertEquals(1, lArrivee.getNumeroArrivee());
		assertEquals(1, lArrivee.getNumeroSortie());
		
		lArrivee.setNumeroArrivee(3);
		assertEquals(3, lArrivee.getNumeroArrivee(), DELTA);
	}
	
	
	
}
