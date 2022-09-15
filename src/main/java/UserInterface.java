import java.util.Scanner;

public class UserInterface {

    Scanner sc;
    Database superData;

    public UserInterface() {
        superData = new Database();
        sc = new Scanner(System.in);
    }

    public void startProgram() {

        int brugerValg = 0;

        do {
            System.out.println("""
                \nVelkommen til Superhelte-programmet
                Tast 1. Indtast superhelt info
                Tast 2. Find superhelt
                Tast 3. Udskiv alle superhelte
                Tast 4. Ret oplysninger
                Tast 9. Luk program
                """);
            brugerValg = sc.nextInt();
            brugerValgMenu(brugerValg);

        }while (brugerValg != 9);

    }

    public void brugerValgMenu(int brugerValg) {
        if (brugerValg == 1)
            indtastSuperhelt();
        else if (brugerValg == 2)
            findSuperhelt();
        else if (brugerValg == 3)
            udskrivSuperhelt();
        else if (brugerValg == 4)
            retOplysninger();
        else if (brugerValg == 9);
        System.exit(9);
    }

    public void indtastSuperhelt() {
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

        System.out.print("Indtast superheltens styrkeniveau fra 1-1000000: ");
        double styrke = sc.nextDouble();

        superData.tilføjSuperhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);
    }

    public void findSuperhelt() {
        System.out.println("Find superhelt. Indtast superheltens navn: ");
        String findHelt = sc.next();
        Superhelt superhelt = superData.findSuperhelt(findHelt);
        if (superhelt == null)
            System.out.println("Superhelt " + findHelt+ " ikke fundet");
        else System.out.println(superhelt);

    }

    public void udskrivSuperhelt() {
        System.out.println("\nSuperheltens stats");

        for (Superhelt superhelt : superData.getSuperhelteData()) {
            System.out.println(superhelt);
        }

    }
    // TODO: lave opslysninger
    public void retOplysninger() {}



}
