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
	
	@Before
	public void setUp() {
		final int NBTOTALPLACEMUSCU = 4;
		final int NBTOTALPLACEFIT = 5;
		final char CHOIXSPORT = 'M';
		
		leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT, "leComplexe");
		lArrivee = new Arrivee(leComplexe, CHOIXSPORT);
	}
	
	@Test
	public void testConstructeur() {
		final char CHOIXSPORT = 'F';
		Arrivee lArrivee2 = new Arrivee(leComplexe, CHOIXSPORT);
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
		leCal.setTimeInMillis(lArrivee.getHoraireArrivee());
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
		
		Date laDate = getHDep().getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		
		leTicket = MSGNOMCOMPLEXE + lArrivee.getComplexe().getNomComplexe() + "\t";
		leTicket += MSGNUMTICKET + ++lArrivee.getNumeroArrivee() + RC;
		leTicket += MSGDATE + leJour.format(laDate) + RC;
		leTicket += MSGHEURE + lHeure.format(laDate) + RC;
		leTicket += MSGMONTANT + lArrivee.getMontant() + "€" + RC;
		
		assertEquals(leTicket, lArrivee.afficheTicket());
	}
	
}
