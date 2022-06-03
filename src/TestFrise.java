import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Frise
 * fonctionne correctement
 */
public class TestFrise {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestFrise(), args);
	}

	/**
	 * test methodes
	 */
	@Test
	public void test_methodes_Frise(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[1];
		tab[0] = new Carte(fich[0]);
					
		Frise f = new Frise();
		Frise frise = new Frise(tab);
		frise.ajouterCarteTrie(new Carte(fich[1]));
		boolean verif = frise.verifierCarteApres(new Carte(fich[3]), 0);
		boolean inser = frise.insererCarteApres(new Carte(fich[3]), 0);
		String tostr = frise.toString();
		Carte c = frise.getCartes(0);
		int nb = frise.getNbCartes();
	}

	/**
	 * test du constructeur parametres
	 */
	@Test
	public void test1_constructeurParam() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[3];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
		tab[2] = new Carte(fich[2]);
					
		Frise frise = new Frise(tab);
		assertEquals("frise devrait avoir 3 cartes", 3, frise.getNbCartes());
		assertEquals("premiere date devrait etre -9000", -9000, frise.getCartes(0).getDate());
		assertEquals("deuxieme date devrait etre -548", -548, frise.getCartes(1).getDate());
		assertEquals("troisieme date devrait etre -200", -200, frise.getCartes(2).getDate());
		
	}

	/**
	 * test du constructeur sans carte
	 */
	@Test
	public void test2_constructeurSansCarte() {
		Carte[] tab = new Carte[0];
		
		Frise frise = new Frise(tab);
		assertEquals("frise devrait avoir 0 cartes", 0, frise.getNbCartes());
		
	}

	/**
	 * test verifierCarteApres OK
	 */
	@Test
	public void test3_verifierCarteApresOK() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[1]);
		tab[1] = new Carte(fich[2]);
					
		Carte test = new Carte(fich[0]);
		Carte test2 = new Carte(fich[3]);
		Frise frise = new Frise(tab);
		assertEquals("1. verifier carte devrait retourner true", true, frise.verifierCarteApres(test, -1));
		assertEquals("2. verifier carte devrait retourner false", false, frise.verifierCarteApres(test2, -1));
		assertEquals("3. verifier carte devrait retourner true", true, frise.verifierCarteApres(test2, 2));
		assertEquals("4. verifier carte devrait retourner false", false, frise.verifierCarteApres(test, 2));
		
	}

	/**
	 * test verifierCarteApres indice hors tableau
	 */
	@Test
	public void test4_verifierCarteApresIndiceTropEleve() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
					
		Carte test = new Carte(fich[2]);
		Frise frise = new Frise(tab);
		assertEquals("verifier carte devrait retourner false", false, frise.verifierCarteApres(test, 17));
	}

	/**
	 * test insererCarteApres OK
	 */
	@Test
	public void test5_insererCarteApresOK() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[1]);
		tab[1] = new Carte(fich[2]);
					
		Carte test = new Carte(fich[0]);
		Carte test2 = new Carte(fich[3]);
		Frise frise = new Frise(tab);
		assertEquals("1. inserer carte devrait retourner true", true, frise.insererCarteApres(test, -1));
		assertEquals("2. inserer carte devrait retourner false", false, frise.insererCarteApres(test2, -1));
		assertEquals("3. inserer carte devrait retourner true", true, frise.insererCarteApres(test2, 2));
		assertEquals("4. inserer carte devrait retourner false", false, frise.insererCarteApres(test, 2));
	}

	/**
	 * test insererCarteApres indice hors tableau
	 */
	@Test
	public void test6_insererCarteApresIndiceTropEleve() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
					
		Carte test = new Carte(fich[2]);
		Frise frise = new Frise(tab);
		assertEquals("verifier carte devrait retourner false", false, frise.insererCarteApres(test, 17));
		assertEquals("il devrait y avoir 2 carte", 2, frise.getNbCartes());
	}

	/**
	 * test ajouterCarteTrie 
	 */
	@Test
	public void test7_ajouterCarteTrieOK() {
		
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
					
		Carte test = new Carte(fich[2]);
		Frise frise = new Frise(tab);
		frise.ajouterCarteTrie(test);

		assertEquals("premiere date devrait etre -9000", -9000, frise.getCartes(0).getDate()); 
		assertEquals("deuxieme date devrait etre -548", -548, frise.getCartes(1).getDate()); 
		assertEquals("troisieme date devrait etre -200", -200, frise.getCartes(2).getDate());
	}

	/**
	 * test toString
	 */
	@Test
	public void test8_toString() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();
		String attendu = "-----------------------------\n0. -9000 -> L'apparition de la ceramique\n1. -200 -> L'invention du papier\n-----------------------------\n";
		
		Carte[] tab = new Carte[2];
		tab[0] = new Carte(fich[0]);
		tab[1] = new Carte(fich[1]);
					
		Frise frise = new Frise(tab);
		assertEquals("toString devrait etre true", true, attendu.equals(frise.toString()));
	}	

	/**
	 * test ajouter une carte trie lorsqu'il n'y a pas de carte dans la frise
	 */
	@Test
	public void test9_ajouterCarteTrieFriseVide(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();

		Carte test = new Carte(fich[0]);
		Frise frise = new Frise();
		frise.ajouterCarteTrie(test);

		assertEquals("il devrait y avoir une carte", 1, frise.getNbCartes()); 
		assertEquals("la date devrait etre -9000", -9000, frise.getCartes(0).getDate()); 

	}

	/**
	 * test verifier carte apres lorsqu'il n'y a pas de carte dans la frise
	 */
	@Test
	public void test10_verifierCarteApresFriseVide(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();
					
		Carte test = new Carte(fich[0]);
		Frise frise = new Frise();
		assertEquals("verifier carte devrait retourner true", true, frise.verifierCarteApres(test, -1));
		assertEquals("verifier carte devrait retourner false", false, frise.verifierCarteApres(test, 0));
	}

	/**
	 * test inserer carte apres lorsqu'il n'y a pas de carte dans la frise
	 */
	@Test
	public void test11_insererCarteApresFriseVide(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
		String[] fich = lf.lireFichier();
					
		Carte test = new Carte(fich[0]);
		Frise frise = new Frise();
		assertEquals("verifier carte devrait retourner true", true, frise.insererCarteApres(test, -1));
		assertEquals("le nombre de carte devrait etre 1", 1, frise.getNbCartes());

		Frise frise2 = new Frise();
		assertEquals("verifier carte devrait retourner false", false, frise2.insererCarteApres(test, 0));
		assertEquals("le nombre de carte devrait etre 0", 0, frise2.getNbCartes());
	}
}