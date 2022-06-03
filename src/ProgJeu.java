import java.util.Scanner;

public class ProgJeu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(args.length == 0){
            System.out.println("Indiquez le fichier à utiliser :\n");
            args[0] = sc.nextLine();
        }

        int i=-1;
        while(i<0 || i>60){
            System.out.println("Indiquez le nombre de la carte dans la main du joueur entre 0 et 60:\n");
            i = sc.nextInt();
        }

        Jeu j = new Jeu(i, args[0]);
        j.fonctionnement();

        sc.close();
    }
}
