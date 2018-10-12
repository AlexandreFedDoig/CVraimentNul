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
    private Calendar heureDepart;
    private int numArrivee = 0;
    private int numSortie = 0;
    
    @Before
    public void setUp() {
        final int NBTOTALPLACEMUSCU = 4;
        final int NBTOTALPLACEFIT = 5;
        final char CHOIXSPORT = 'M';
        
        leComplexe = new Complexe(NBTOTALPLACEMUSCU, NBTOTALPLACEFIT, "leComplexe");
        lArrivee = new Arrivee(leComplexe, CHOIXSPORT);
        this.horaireArrivee = Calendar.getInstance().getTimeInMillis();
        this.numArrivee += 1;
        
    }

    @Test
    public void testAfficheBillet() {
        final String MSGNOMCOMPLEXE = "Complexe ";
        final String MSGNUMBILLET = "Billet d'entrée n° : ";
        final String MSGDATE = "Date : ";
        final String MSGHEURE = "Heure : ";
        final String RC = "\n";
        final String NOMCOMPLEXE = "leComplexe";
        
        String leBillet;
        
        Calendar leCal = Calendar.getInstance();
        leCal.setTimeInMillis(horaireArrivee);
        Date laDate = leCal.getTime();
        SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
        
        leBillet = MSGNOMCOMPLEXE + NOMCOMPLEXE + "\t";
        leBillet += MSGNUMBILLET + numArrivee + RC;
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
        final String NOMCOMPLEXE = "leComplexe";
        
        String leTicket;
        Calendar heureDepart = Calendar.getInstance();
        
        Date laDate = heureDepart.getTime();
        SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
        
        leTicket = MSGNOMCOMPLEXE + NOMCOMPLEXE + "\t";
        leTicket += MSGNUMTICKET + ++numSortie + RC;
        leTicket += MSGDATE + leJour.format(laDate) + RC;
        leTicket += MSGHEURE + lHeure.format(laDate) + RC;
        leTicket += MSGMONTANT + 0 + "€" + RC;
        
        assertEquals(leTicket, lArrivee.afficheTicket());
    }
    
    @Test
    public void testGetMontant() {
        double cout = 0;
        final double DELTA = 0.001;
        
        //test avec l'heure de depart non instanciée
        assertEquals(cout, lArrivee.getMontant(), DELTA);
        
        //test avec 23 min de durée
        cout = 0.5;
        heureDepart = Calendar.getInstance();
        heureDepart.add(Calendar.MINUTE, +23);
        lArrivee.sethDep(heureDepart);
        assertEquals(cout, lArrivee.getMontant(), DELTA);
        
        //test avec 47 min de durée
        cout = 1;
        heureDepart.add(Calendar.MINUTE, +24);
        lArrivee.sethDep(heureDepart);
        assertEquals(cout, lArrivee.getMontant(), DELTA);
        
        //test avec 1h03 de durée
        cout = 1.5;
        heureDepart.add(Calendar.MINUTE, +16);
        lArrivee.sethDep(heureDepart);
        assertEquals(cout, lArrivee.getMontant(), DELTA);
    }
    
    @Test
    public void testSetters() {
        lArrivee.setNumeroArrivee(1);
        assertEquals(1, lArrivee.getNumeroArrivee());
    }
}
