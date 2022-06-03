import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * test les méthodes
	 */
	@Test
	public void test_methodes_Paquet(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[1];
		tab[0] = new Carte(fich[0]);
					
		Paquet p = new Paquet();
		Paquet paquet = new Paquet(tab);
		int nb = paquet.getNbCartes();
		Carte c = paquet.getCarte(0);
		paquet.ajouterCarteFin(new Carte(fich[1]));
		paquet.retirerCarte(0);
		paquet.ajouterCarteDebut(new Carte(fich[2]));
		paquet.ajouterCarte(new Carte(fich[3]), 2);
		c = paquet.piocherHasard();
		String toStr = paquet.toString();
	}

	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		Paquet paquet = new Paquet();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}

	/**
	 * test du constructeur parametres
	 */
	@Test
	public void test2_constructeurParam() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}


    /**
	 * test getCarte
	 */
	@Test
	public void test3_getCarte_ok() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

        Carte c = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur -200", -200, c.getDate());
	}

	/**
	 * test getCarte hors tableau
	 */
	@Test
	public void test4_getCarte_horsTableau() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);
	}

	/**
	 * test ajoutCarteFin ok
	 */
	@Test
	public void test5_ajoutCarteFin() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		paquet.ajouterCarteFin(new Carte(fich[3]));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

		Carte c = paquet.getCarte(0);
		assertEquals("la carte 0 a pour valeur -9000", -9000, c.getDate());	
		assertEquals("evenement carte 0 devrait etre L'apparition de la ceramique", "L'apparition de la ceramique", c.getEvenement());
		assertEquals("recto carte 0 devrait etre false", false, c.getRecto());
		Carte c1 = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur -200", -200, c1.getDate());	
		assertEquals("evenement carte 1 devrait etre L'invention du papier", "L'invention du papier", c1.getEvenement());
		assertEquals("recto carte 1 devrait etre false", false, c1.getRecto());
		Carte c2 = paquet.getCarte(2);
		assertEquals("la carte 2 a pour valeur -548", -548, c2.getDate());	
		assertEquals("evenement carte 2 devrait etre La fondation du theoreme de Pythagore", "La fondation du theoreme de Pythagore", c2.getEvenement());
		assertEquals("recto carte 2 devrait etre false", false, c2.getRecto());
		Carte c3 = paquet.getCarte(3);
		assertEquals("la carte 3 a pour valeur 1838", 1838, c3.getDate());	
		assertEquals("evenement carte 3 devrait etre L'invention du morse", "L'invention du morse", c3.getEvenement());
		assertEquals("recto carte 3 devrait etre false", false, c3.getRecto());
		
	}

	/**
	 * test retirerCarte ok
	 */
	@Test
	public void test6_retirerCarte() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		Carte c = paquet.retirerCarte(1);
		
		// test paquet
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		Carte c1 = paquet.getCarte(0);
		assertEquals("premiere carte valeur -9000", -9000, c1.getDate());
		assertEquals("evenement premiere carte devrait etre L'apparition de la ceramique", "L'apparition de la ceramique", c1.getEvenement());
		assertEquals("recto premiere carte devrait etre false", false, c1.getRecto());
		Carte c2 = paquet.getCarte(1);
		assertEquals("seconde carte valeur -548", -548, c2.getDate());
		assertEquals("evenement seconde carte devrait etre La fondation du theoreme de Pythagore", "La fondation du theoreme de Pythagore", c2.getEvenement());
		assertEquals("recto seconde carte devrait etre false", false, c2.getRecto());
			
		// test carte retirer
		assertEquals("carte retiree a pour valeur -200", -200, c.getDate());
		assertEquals("evenement carte retiree devrait etre L'invention du papier", "L'invention du papier", c.getEvenement());
		assertEquals("recto carte retiree devrait etre false", false, c.getRecto());
  
		
	}


	/**
	 * test piocherHasard OK
	 */
	@Test
	public void test7_piocherHasardOK() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Paquet paquet = new Paquet(tab);
		Carte c = paquet.piocherHasard();
		
		if(c == tab[0]){
			assertEquals("date devrait etre -9000", -9000, c.getDate());
			assertEquals("evenement devrait etre L'apparition de la ceramique", "L'apparition de la ceramique", c.getEvenement());
			assertEquals("recto devrait etre false", false, c.getRecto());
		}else if(c == tab[1]){
			assertEquals("date devrait etre -200", -200, c.getDate());
			assertEquals("evenement devrait etre L'invention du papier", "L'invention du papier", c.getEvenement());
			assertEquals("recto devrait etre false", false, c.getRecto());
		}else{
			assertEquals("date devrait etre -548", -548, c.getDate());
			assertEquals("evenement devrait etre La fondation du theoreme de Pythagore", "La fondation du theoreme de Pythagore", c.getEvenement());
			assertEquals("recto devrait etre false", false, c.getRecto());
		}
	}

	/**
	 * test toString
	 */
	@Test
	public void test8_toString() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();
		String attendu = "-----------------------------\n0. ??? -> L'apparition de la ceramique\n1. ??? -> L'invention du papier\n-----------------------------\n";
		
		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
					
		Paquet paquet = new Paquet(tab);
		assertEquals("toString devrait etre true", true, attendu.equals(paquet.toString()));
	}																																																																											    

}
