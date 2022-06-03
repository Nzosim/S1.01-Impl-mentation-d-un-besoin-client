/**
 * classe Carte 
 */
public class Carte{

  /** 
   * attribut de la classe carte 
   * une chaine de caractere evenement representant le titre de la carte
   * un entier date qui represente la date a laquelle l evenement de la carte a eu lieu
   * un boolean recto qui indique si la carte est retourner ou non lorsque recto est faux on ne voit pas la date
   */
  private String evenement;
  private int date;
  private boolean recto = false;

  /**
   * constructeur de la classe carte converti une chaine de caractere en une carte
   * @param nom nom de la carte 
   */
  public Carte (String nom){        
    int i=0;
    String n="";
    while(nom.charAt(i) != ':'){
      n+=nom.charAt(i);
      i++;
    }
    this.evenement=n;
    i++;
    String date="";
    while(i< nom.length()){
      date+=nom.charAt(i);
      i++;
    }
    this.date=Integer.parseInt(date);
  }

  /**
   * methode toString de la classe carte
   * @return la carte sour le format date -> evenement
   */
  public String toString(){
    String res = "";
    if(recto){
      res += this.date;
    }else{
      res+= "???";
    }
    return res+" -> "+this.evenement;
  }

  /**
   * methode retournerCarte qui permet de retourner la carte
   */
  public void retournerCarte(){
    if(this.recto == false){
      this.recto = true;
    }else{
      this.recto = false;
    }
  }

  /**
   * getter evenement
   * @return evenement de la carte
   */
  public String getEvenement(){
    return this.evenement;
  }

  /**
   * getter date 
   * @return date de la carte
   */
  public int getDate(){
    return this.date;
  }

  /**
   * getter recto 
   * @return si la carte est face recto ou non
   */
  public boolean getRecto(){
    return this.recto;
  }

  /**
   * setter recto permet d assigner recto a true
   */
  public void setRecto(){
    this.recto = true;
  }

  /**
   * setter verso permet d assigner recto a false
   */
  public void setVerso(){
    this.recto = false;
  }
} 