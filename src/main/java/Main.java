import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Database superData = new Database();
        int brugerValg = 0;

        do {
            System.out.println("""
                \nVelkommen til Superhelte-programmet
                Tast 1. for at starte programmet
                Tast 2. for at udskrive alle helte
                Tast 9. for at slutte programmet
                """);

            brugerValg= sc.nextInt();

            sc.nextLine();
            if (brugerValg == 1) {
                System.out.print("Indtast superheltens aliasnavn: ");
                String aliasNavn = sc.nextLine();

                System.out.print("Indtast superheltens supernavn: ");
                String superNavn = sc.nextLine();

                System.out.print("Indtast superheltens superkraft: ");
                String superkraft = sc.nextLine();

                System.out.print("Er superhelten menneske? Indtast Ja eller Nej: ");
                String erMenneske = sc.next();
                boolean menneske = false;
                if(erMenneske.equalsIgnoreCase("Ja")){
                    menneske = true;
                } else if (erMenneske.equalsIgnoreCase("Nej")){
                    menneske = false;
                }

                System.out.print("Indtast superheltens oprindelsesår: ");
                int oprindelsesÅr = sc.nextInt();
                sc.nextLine();

                System.out.print("Indtast superheltens styrkeniveau fra 1-10000: ");
                double styrke = sc.nextDouble();

                superData.tilføjSuperhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);

            } else if(brugerValg == 2) {
                System.out.println("\nSuperheltens stats");

                for (Superhelt superhelt : superData.getSuperhelteData()) {
                    System.out.println(superhelt);
                }

            } else {
                System.exit(0);
            }

        } while (brugerValg != 9);



    }
}
