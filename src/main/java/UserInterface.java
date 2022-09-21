
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Scanner sc;
    Database superData;
    int brugerValg = 0;

    public UserInterface() {
        superData = new Database();
        sc = new Scanner(System.in);
    }

    public void startProgram() {

        System.out.println(BLACK_BOLD+"\nVelkommen til Superhelte-databasen"+RESET);

        do {
            System.out.println(BLACK_UNDERLINED+"\nTast nr. for at tilgå et menupunkt"+RESET);
            System.out.println("""
                1. Indtast superhelt data
                2. Find superhelt
                3. Find alle superhelte
                4. Rediger superhelt
                5. Slet superhelt
                9. Luk program
                """);

            System.out.print(RED+"Menuvalg: "+RESET);
            brugerValg = læsInteger();
            brugerValgMenu(brugerValg);
        }
        while (brugerValg != 9);

    }

    public void brugerValgMenu (int brugerValg) {
       switch (brugerValg) {
           case 1: indtastSuperhelt();
               break;
           case 2: findSuperhelt();
               break;
           case 3: udskrivSuperhelt();
               break;
           case 4: retOplysninger();
               break;
           case 5: deleteSuperhelt();
               break;
           case 9:
               System.out.println("Lukker program. Farvel!");
           default:
               System.out.println("Forkert menupunkt! Prøv igen.");
       }
    }


    // TODO: Hvis der er tid, så prøv at lav metode med undermenu
    /*
    public void uIndtastSuperhelt() {
        System.out.println(BLACK_UNDERLINED + "Du har valgt: 1. Indtast superhelt data" + RESET);
        System.out.println("""
                5. Forsæt til: Intast superhelte data
                6. Tilbage til: Menupunkter""");

        while (brugerValg != 9) {

            if (brugerValg == 5) {
                indtastSuperhelt();
            } else if (brugerValg == 6) {
                startProgram();
            }
            brugerValg = læsInteger();
            brugerValgMenu(brugerValg);
        }
    }
     */



    //punkt 1 - indtast superhelt
    public void indtastSuperhelt() {

        System.out.println(BLACK_UNDERLINED+"\nIndtast data på superhelt"+RESET);
        System.out.print("Aliasnavn: ");
        String aliasNavn = sc.next();

        sc.nextLine();
        System.out.print("Supernavn: ");
        String superNavn = sc.nextLine();

        System.out.print("Superkraft: ");
        String superkraft = sc.nextLine();

        System.out.print("Menneske? Indtast Ja eller Nej: ");
        String erMenneske = sc.next();
        boolean menneske = false;
        if(erMenneske.equalsIgnoreCase("Ja")){
            menneske = true;
        } else if (erMenneske.equalsIgnoreCase("Nej")){
            menneske = false;
        }

        sc.nextLine();
        System.out.print("Oprindelsesår: ");
        int oprindelsesÅr = læsInteger();

        sc.nextLine();
        System.out.print("Styrkeniveau fra 1-1000000: ");
        double styrke = læsDouble();

        superData.tilføjSuperhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);
    }

    // punkt 2 - find superhelt
    public void findSuperhelt() {
        //int i = 0;
        System.out.print("\nIndtast superheltens aliasnavn, supernavn og tryk ENTER: ");
        String findHelt = sc.next();
        Superhelt superhelt = superData.findSuperhelt(findHelt);
        if (superhelt == null)
            System.out.println("Din søgning gav intet resultat");
        else
            System.out.println(BLACK_UNDERLINED+"\nSøge resultat:"+RESET);
            System.out.println(superhelt);

    }

    // punkt 3 - find alle superhelte
    public void udskrivSuperhelt() {
        System.out.println(BLACK_UNDERLINED+"\nAlle superhelte i databasen"+RESET);
        for (Superhelt superhelt : superData.getSuperhelteData()) {
            System.out.println(superhelt + "\n");
        }

    }

    // punkt 4 - rediger superhelt
    public void retOplysninger() {

        for (int i = 0; i <superData.getSuperhelteData().size(); i++) {
            System.out.println(i+1 + ":\n"+ superData.getSuperhelteData().get(i)+ "\n");
        }

        System.out.println();
        System.out.print("Indtast nr. og tryk ENTER: ");
        int nr = sc.nextInt();
        sc.nextLine();

        Superhelt retSuperhelt = superData.getSuperhelteData().get(nr-1);

        System.out.println("\nSpring datapunkt over tryk ENTER.");
        System.out.println(BLACK_UNDERLINED + "Rediger data og tryk ENTER for at gemme."+ RESET);

        System.out.print("Aliasnavn " + retSuperhelt.getAliasNavn() + ": ");
        String nytAliasNavn = sc.nextLine();
        if(!nytAliasNavn.isEmpty()) {
            retSuperhelt.setAliasNavn(nytAliasNavn);
        }

        System.out.print("Supernavn " + retSuperhelt.getSuperNavn() + ": ");
        String nytSuperNavn = sc.nextLine();
        if(!nytSuperNavn.isEmpty()) {
            retSuperhelt.setSuperNavn(nytSuperNavn);
        }

        System.out.print("Superkaft " + retSuperhelt.getSuperkraft() + ": ");
        String nySuperkraft = sc.nextLine();
        if(!nytSuperNavn.isEmpty()) {
            retSuperhelt.setSuperkraft(nySuperkraft);
        }

        // TODO: loop den, få de til at fungere i morgen / Exception
        System.out.print("Er superhelt menneske (ja/nej): ");
        String nytMenneske;

        nytMenneske = sc.nextLine();
        boolean nyM = false;
        if(!nytMenneske.isEmpty()) {
            if (nytMenneske.equalsIgnoreCase("ja")) {
                nyM = true;
            } else if (nytMenneske.equalsIgnoreCase("nej")) {
                nyM = false;
            } else {
                System.out.println("Du skal skrive JA eller NEJ");
            }
        }

        System.out.print("Oprindelsesår " + retSuperhelt.getOprindelsesÅr() +": ");
        String nytOprindelsesår = sc.nextLine();
        if(!nytOprindelsesår.isEmpty()) {
            retSuperhelt.setOprindelsesÅr(Integer.parseInt(nytOprindelsesår));
        }

        System.out.print("Styrke " + retSuperhelt.getStyrke() + ": ");
        String nyStyrke = sc.nextLine();
        if (!nyStyrke.isEmpty()) {
            retSuperhelt.setStyrke(Integer.parseInt(nyStyrke));
        }

    }

    // delete Superhelt
    public void  deleteSuperhelt () {
        // Finder alle Superhelte i ArrayListen (Databasen)
        for (int i = 0; i <superData.getSuperhelteData().size(); i++) {
            System.out.println(i+1 + ":\n"+ superData.getSuperhelteData().get(i)+ "\n");
        }

        int nr;
        do {
            System.out.println();
            System.out.print("Indtast nr. og tryk ENTER for at slette: ");

            nr = læsInteger();
            sc.nextLine();
            if (nr <= superData.getSuperhelteData().size()) { // if = Hvis indtastet tal matcher Supersupeltens plads i Arraylisten = slet
                superData.getSuperhelteData().remove(nr-1);
                System.out.println(RED+"\nSuperhelt slettet!"+RESET);
            } else {
                System.out.println(RED+"Forkert nummer. Prøv igen!"+RESET); // else = servicebesked
            }

        } while (nr > superData.getSuperhelteData().size());

    }

    public int læsInteger() {
        while (!sc.hasNextInt()) {  //Loop
            String text = sc.nextLine();
            System.out.println(RED + text + RESET + " er ikke et heltal. Prøv igen.\n");
        }
        return sc.nextInt();
    }
    public double læsDouble() {
        while (!sc.hasNextDouble()) {  //Loop
            String text = sc.nextLine();
            System.out.println(RED + text + RESET + " er ikke et tal. Prøv igen.\n");
        }
        return sc.nextDouble();
    }

    // Farver
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK BLOD
    public static final String RED = "\033[0;31m";     // RED



}
