import java.util.Scanner;

/**
 * classe jeu
 */
public class Jeu {
    
    /**
     * attribut de la classe jeu
     * un Paquet de carte mainJ qui represente la main du joueur
     * un Paquet de carte Pioche qui represente la pioche du jeu
     * une Frise frise qui represente la frise des cartes deja place
     */
    private Paquet mainJ = new Paquet();
    private Paquet pioche = new Paquet();
    private Frise frise = new Frise();

    /**
     * constructeur de la classe jeu qui ajoute les cartes du fichier en parametre dans la pioche
     * et ajoute le bon nombre de carte a la main du joueur en fonction de tailleMain
     * @param tailleMain taille de la main du joueur
     * @param nomFicher nom du fichier qui contient les cartes
     */
    public Jeu(int tailleMain, String nomFicher){
        
        this.pioche = new Paquet(nomFicher);

        Carte[] cm = new Carte[tailleMain];
        for(int i = 0; i < tailleMain; i++){
            if(this.pioche.getNbCartes() != 0) cm[i]=pioche.piocherHasard();
        }
        this.mainJ= new Paquet(cm);
    }


    /**
     * methode fin permet de savoir si le jeu est terminer ou non le jeu se termine lorsque la pioche est vide 
     * ou lorsque la main du joueur est vide
     * @return si le jeu est fini ou non 
     */
    public boolean fin(){
        return (this.mainJ.getNbCartes() == 0 || this.pioche.getNbCartes() == 0);
    }

    /**
     * methode fonctionnement permet de jouer, elle demande une carte a poser et une place 
     * et essaie de la placer si possible tout en verifiant si le jeu est fini ou non
     */
    public void fonctionnement(){
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------\nmain du joueur\n--------------\n");
        System.out.println(this.mainJ);
        System.out.println("Choisir une premiere carte !");
        
        Carte[] friseIni = new Carte[1];

        int valeur = sc.nextInt();
        while (valeur < 0 || valeur > this.mainJ.getNbCartes()-1){
                System.out.println("carte inexistante");
                valeur = sc.nextInt();
            }
        Carte c = this.mainJ.getCarte(valeur);
        c.setRecto();
        this.mainJ.retirerCarte(valeur);

        friseIni[0] = c;

        Frise newFrise = new Frise(friseIni);

        this.frise = newFrise; 

        while(!this.fin()){


            String res="-----------------------------\nfrise\n";
            res+=this.frise;
            res+="main du joueur\n";
            res+=mainJ;
            System.out.println(res);


            int cart = -1;
            while (cart < 0 || cart >= this.mainJ.getNbCartes()){
                System.out.println("Quel carte de votre main ?");
                cart = sc.nextInt();
            }
            System.out.println(this.mainJ.getCarte(cart));

            int pos = -2;
            while(pos < -1 || pos > this.frise.getNbCartes()-1){
                System.out.println("Derriere quelle carte de la frise ?");
                pos = sc.nextInt();
            }

            System.out.println("- carte jouee : "+this.mainJ.getCarte(cart));
            if(pos == -1){
                System.out.println("avant ...\n   - "+this.frise.getCartes(0)+"\n");
            }else if(pos == this.frise.getNbCartes()){
                System.out.println("entre ...\n   - "+this.frise.getCartes(pos)+"\n   - "+this.frise.getCartes(pos+1)+"\n");
            }else{
                System.out.println("apres ...\n   - "+this.frise.getCartes(pos)+"\n");
            }

            if(this.frise.verifierCarteApres(this.mainJ.getCarte(cart), pos)){
                // this.mainJ.getCarte(cart).setRecto();
                this.frise.insererCarteApres(this.mainJ.getCarte(cart), pos);
                
                
                //      if(this.pioche.getNbCartes() != 0) c = this.pioche.piocherHasard();;
                //Quand on place une carte on ne repioche pas :/
                
                //c.retournerCarte();
                //Sthis.mainJ.ajouterCarteFin(c);
                System.out.println("!!! Une carte de placee !!!");
            }else{
                System.out.println("NNNNNOOOOOONNNNNNNN");
                //if(this.pioche.getNbCartes() != 0) this.mainJ.ajouterCarteFin(this.pioche.piocherHasard());
                if (this.pioche.getNbCartes() > 0){
                    this.mainJ.ajouterCarteFin(this.pioche.piocherHasard());
                }
            }
            this.mainJ.retirerCarte(cart);
            for(int i =0;i<this.mainJ.getNbCartes();i++){
                this.mainJ.getCarte(i).setVerso();
            }
            for(int i =0;i<this.frise.getNbCartes();i++){
                this.frise.getCartes(i).setRecto();
            }
            System.out.println("________________________________________________________________________________________________________");
            System.out.println("Nombre de carte de la Pioche : "+this.pioche.getNbCartes());
        }
        if (this.mainJ.getNbCartes()==0){
            System.out.println("VICTOIRE");
        } else if (this.pioche.getNbCartes()==0){
            System.out.println("DEFAITE");
        }

        sc.close();
    }

}