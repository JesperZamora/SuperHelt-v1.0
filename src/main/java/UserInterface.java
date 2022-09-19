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
                9. Luk program
                """);

            System.out.print(RED+"Menuvalg: "+RESET);
            brugerValg = læsInteger();
            brugerValgMenu(brugerValg);
        }
        while (brugerValg != 9);

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
        else
        System.exit(9);
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

    public void findSuperhelt() {
        System.out.print("\nIndtast superheltens aliasnavn, supernavn og tryk ENTER: ");
        String findHelt = sc.next();
        Superhelt superhelt = superData.findSuperhelt(findHelt);
        if (superhelt == null)
            System.out.println("Din søgning gav intet resultat");
        else
            System.out.println(BLACK_UNDERLINED+"\nSøge resultat:"+RESET);
            System.out.println(superhelt);

    }

    public void udskrivSuperhelt() {
        System.out.println(BLACK_UNDERLINED+"\nAlle superhelte i databasen"+RESET);
        for (Superhelt superhelt : superData.getSuperhelteData()) {
            System.out.println(superhelt);
        }

    }


    public void retOplysninger() {
        for (int i = 0; i <superData.getSuperhelteData().size(); i++) {
            System.out.println(BLACK_UNDERLINED+"\nSuperhelt Nr. "+i+1 + ":\n"+RESET + superData.getSuperhelteData());
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

        do {
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

        } while (nytMenneske != "ja" || nytMenneske != "nej");


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
    /*
    try {
        checkInteger();
    }
    catch (IllegalAccessException e) {
        System.out.println(checkInteger.getMessage());
    }
    l
     */

    /*
    public void checkInteger(brugerValg) {
        for (brugerValg > 9) {
            throw new IllegalArgumentException("Kun tal mindre end 9");
        }
    }

 */
    /*
            sc.nextLine();
        System.out.print("Indtast superheltens oprindelsesår: ");
    int oprindelsesÅr = læsInteger();

        while (!sc.hasNextInt()) {  //Loop
            int text = sc.nextInt();
            System.out.println("Dette" + text + "er ikke et tal. Prøv igen.");
        }
        int oprindelsesÅr = sc.nextInt();

         */

}
