import java.util.Random;

/**
 * classe Paquet 
 */
public class Paquet {
    
    /**
     * attribut de la classe Paquet
     * un tableau de Carte nomme carte
     */
    private Carte[] carte;

    /**
     * constructeur de la classe Paquet qui construit un tableau de carte vide
     */
    public Paquet(){
        carte = new Carte[0];
    }

    /**
     * deuxieme constructeur de Paquet ajoute le tableau de Carte c au tableau de Carte du paquet
     * @param c un tableau de carte
     */
    public Paquet(Carte[] c){
        this.carte=c;
    }

    /**
     * getter nombre de carte
     * @return nombre de carte dans le tableau cartes
     */
    public int getNbCartes(){
        return this.carte.length;
    }

    /**
     * getter carte retourner la carte a l indice place
     * @param place indice recherche
     * @return la carte a l indice place
     */
    public Carte getCarte(int place){
        Carte res=null;
        if(place < carte.length){
            res=this.carte[place];
        }
        return res;
    }

    /**
     * methode ajouterCarteFin ajoute une carte c a la fin du paquet de carte
     * @param c carte a ajouter
     */
    public void ajouterCarteFin(Carte c){
        Carte[] a = new Carte[this.carte.length+1];
        int i=0;
        for(i=0;i<carte.length;i++){
            a[i]=this.carte[i];
        }
        a[i]=c;
        this.carte = a;
    }

    /**
     * methode retirerCarte qui retire une carte a l'indice place
     * @param place indice de la carte a retirer
     * @return la carte retire
     */
    public Carte retirerCarte(int place){
        Carte res = null;
        if(place <= this.carte.length){
            Carte[] a = new Carte[this.carte.length-1];
            int i =0;
            while(i<place && i<this.carte.length){
                a[i]=this.carte[i];
                i++;
            }
            while(i<this.carte.length-1){
                a[i]=this.carte[i+1];
                i++;
            }
            res = this.carte[place];
            this.carte = a;
        }
        return res;
    }

    /**
     * methode ajouterCarteDebut ajoute la carte en parametre au debut du paquet
     * @param c carte a ajouter
     */
    public void ajouterCarteDebut(Carte c){
        Carte[] a = new Carte[this.carte.length+1];
        a[0]=c;
        for(int i=1;i<=carte.length;i++){
            a[i]=this.carte[i-1];
        }
        this.carte = a;
    }

    /**
     * methode ajouterCarte qui ajoute une carte c apres l indice place
     * @param c carte a ajouter
     * @param place indice ou l on veux placer la carte
     */
    public void ajouterCarte(Carte c, int place){
        if(place<this.carte.length){
            Carte[] ca = new Carte[this.carte.length+1];
            int i =0;
            while(i<=place){
                ca[i]=this.carte[i];
                i++;
            }
            ca[i]=c;
            i++;
            while(i<this.carte.length){
                ca[i]=this.carte[i-1];
                i++;
            }
            this.carte=ca;
        }
    }

    /**
     * constructeur de la classe paquet qui transforme le contenu d un fichier en paquet de carte
     * @param nomFicher nom du fichier
     */
    public Paquet(String nomFicher){
        LectureFichier lf = new LectureFichier(nomFicher);
        String[] fich = lf.lireFichier();

        this.carte = new Carte[fich.length];
        for(int i=0; i<fich.length; i++){
            Carte c = new Carte(fich[i]);
            this.carte[i]=c;
        }
    }

    /**
     * methode piocherHasard pioche une carte au hasard et la retire du paquet
     * @return la carte pioche  
     */
    public Carte piocherHasard(){
        Carte res = null;
        Random r = new Random();
        if(this.carte.length > 0){
            int rdm = r.nextInt(this.carte.length);
            res = this.carte[rdm];
            this.retirerCarte(rdm);
            res.setVerso();
        }
        return res;
    }

    /**
     * methode toString de la classe Paquet
     * @return les cartes du paquet 
     */
    public String toString(){
        String res ="-----------------------------\n";
        for(int i =0;i<this.carte.length;i++){
            res += i+". "+this.carte[i].toString()+"\n";
        }
        return res+"-----------------------------\n";
    }
}