import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

	/**
	 * test les méthodes
	 */
	@Test
	public void test_methodes_Cartes(){
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
        String[] fich = lf.lireFichier();

		Carte c = new Carte(fich[0]);
		String to = c.toString();
		String ev = c.getEvenement();
		int d = c.getDate();
		boolean rect = c.getRecto();
		c.retournerCarte();
	}

	/**
	 * test du constructeur carte OK
	 */
	@Test
	public void test1_constructeurCarteOK() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
        String[] fich = lf.lireFichier();

		Carte c = new Carte(fich[0]);

		assertEquals("nom devrait etre : L'apparition de la ceramique", "L'apparition de la ceramique", c.getEvenement());
		assertEquals("valeur devrait etre : -9000", -9000, c.getDate());
		assertEquals("recto devrait etre : false", false, c.getRecto());
	}

	/**
	 * test methode toString recto et verso
	 */
	@Test
	public void test2_toStringRectoEtVerso() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
        String[] fich = lf.lireFichier();

		Carte c = new Carte(fich[0]);

		assertEquals("devrait retourner : ??? -> L'apparition de la ceramique", "??? -> L'apparition de la ceramique", c.toString());
		c.retournerCarte();
		assertEquals("devrait retourner : -9000 -> L'apparition de la ceramique", "-9000 -> L'apparition de la ceramique", c.toString());
	}

	/**
	 * test methode retournerCarte
	 */
	@Test
	public void test3_retournerCarteOK() {
		LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
        String[] fich = lf.lireFichier();

		Carte c = new Carte(fich[0]);

		assertEquals("recto devrait etre false", false, c.getRecto());
		c.retournerCarte();
		assertEquals("recto devrait etre true", true, c.getRecto());
	}
}