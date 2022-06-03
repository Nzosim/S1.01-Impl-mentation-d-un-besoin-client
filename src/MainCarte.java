/**
 * classe MainCarte
 */
public class MainCarte {
    /**
     * main
     */
    public static void main(String[] args) {
        LectureFichier lf = new LectureFichier("../cartes/timeline.txt");
        String[] fich = lf.lireFichier();
        
        for(int i=0; i<fich.length;i++){
            Carte c = new Carte(fich[i]);
            System.out.println(c);
            c.retournerCarte();
            System.out.println(c);
            System.out.println(); 
        }
    }
}
