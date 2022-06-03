/**
 * classe Frise
 */
public class Frise{

    /**
     * attribut de la classe carte
     * tableau de cartes nomme cartes
     */
    private Carte[] cartes;

    /**
     * constructeur de la classe frise qui permet d inserer un tableau de carte dans l attribut cartes
     * @param c tableau de carte
     */
    public Frise(Carte[] c){
        this.cartes = c;
        for(int i=0; i<this.cartes.length;i++){
            for(int j=0; j<this.cartes.length;j++){
                c[i].retournerCarte();
                if(this.cartes[i].getDate() < this.cartes[j].getDate()){
                    Carte sto = this.cartes[i];
                    this.cartes[i] = this.cartes[j];
                    this.cartes[j]=sto;
                }
            }
        }
    }
    
    /**
     * deuxieme constructeur de la classe frise permet de construire une grise vide
     */
    public Frise(){
        this.cartes = new Carte[0];
    }

    /**
     * methode ajouterCarteTrie permet d ajouter une carte dans la frise a la bonne place 
     * @param c une carte
     */
    public void ajouterCarteTrie(Carte c){
        Carte[] newTab = new Carte[this.cartes.length+1];
        c.retournerCarte();

        if(this.cartes.length != 0){
            int ind = 0;
            boolean trouver = false;

            while ( !trouver&& ind < this.cartes.length){
                if (this.cartes[ind].getDate()>c.getDate()){
                    trouver = true;
                } else {
                    ind++;
                }
            }

            if (!trouver){
                for (int i = 0; i < this.cartes.length; i++){
                    newTab[i] = this.cartes[i];
                }
                newTab[newTab.length-1] = c;
            }

            if (trouver){
                for (int i = 0; i < ind; i++){
                    newTab[i] = this.cartes[i];
                }
                newTab[ind] = c;
                for (int i = ind; i < this.cartes.length; i++){
                    newTab[i+1]=this.cartes[i];
                }
            }

            this.cartes = newTab;
        }else{
            newTab[0] = c;
            this.cartes=newTab;
        }
    }

    /**
     * methode verifierCarteApres permet de verifier si une carte c peut etre place a une place p
     * @param c une carte
     * @param p place teste 
     * @return si la carte peut etre place
     */
    public boolean verifierCarteApres(Carte c, int p){
        boolean res = false;
        if(this.getNbCartes() == 0){
            res = true;
            if(p != -1){
                res = false;
                return res;
            }
        }else if (p < this.getNbCartes()-1) {
            if(p == -1){
                if (this.cartes[0].getDate() > c.getDate()) {
                    res = true;
                }
            }else if (this.cartes[p].getDate() < c.getDate() && this.cartes[p+1].getDate() > c.getDate()) {
                res = true;
            }
        }else if(this.cartes[this.getNbCartes()-1].getDate() < c.getDate()){
            res = true;
        }
        return res;
    }

    /**
     * methode insererCarteApres permet d inserer une carte c a une place p si c est possible 
     * @param c la carte a place
     * @param p la place ou l on souhaite la place 
     * @return si la carte a ete place
     */
    public boolean insererCarteApres(Carte c, int p){
        boolean res = false;
        if(this.verifierCarteApres(c, p)){
            this.ajouterCarteTrie(c);
            res=true;
        }
        return res;
    }

    /**
     * methode toString de la classe frise
     * @return toute les cartes de la frise
     */
    public String toString(){
        String res ="-----------------------------\n";
        for(int i=0;i<this.cartes.length;i++){
            res += i+". "+this.cartes[i].toString()+"\n";
        }
        return res+"-----------------------------\n"; 
    }

    /**
     * getter cartes
     * @param i indice de la carte recherche
     * @return la carte a l indice i
     */
    public Carte getCartes(int i){
        return this.cartes[i];
    }

    /**
     * getter nombre carte
     * @return le nombre de carte de la frise
     */
    public int getNbCartes(){
        return this.cartes.length;
    }

}