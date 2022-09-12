import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Velkommen til Superhelte-programmet\n");

        Scanner sc = new Scanner(System.in);

        //TODO: skal have lavet et loop her, hvor bruger kan vælge om de vil indtaste superhelt eller afslutte

        System.out.print("Indtast superheltens alias-navn: ");
        String aliasNavn = sc.nextLine();

        System.out.print("Indtast superheltens supernavn: ");
        String superNavn = sc.nextLine();

        System.out.print("Indtast superheltens superkraft: ");
        String superkraft = sc.nextLine();

        //TODO: lav en if else statement
        System.out.print("Indtast true/false. Er superhelten menneske?: ");
        boolean menneske = sc.nextBoolean();

        System.out.print("Indtast superheltens oprindelsesår: ");
        int oprindelsesÅr = sc.nextInt();

        System.out.print("Indtast superheltens styrkeniveau: ");
        double styrke = sc.nextDouble();


        Database superData = new Database();

        superData.tilføjSuperhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);


        //TODO: hver gang jeg sætter den ind it loop får jeg en null point exception??
        System.out.println("\n--Superheltens stats--");
        System.out.println("Alias: " + superData.getSuperheltData()[0].getAliasNavn());

        System.out.println("Supernavn: " + superData.getSuperheltData()[0].getSuperNavn());

        System.out.println("Superkraft: " + superData.getSuperheltData()[0].getSuperkraft());

        System.out.println("Menneske: " + superData.getSuperheltData()[0].getMenneske());

        System.out.println("Oprindelsesår: " + superData.getSuperheltData()[0].getOprindelsesÅr());

        System.out.println("Styrkeniveau : " + superData.getSuperheltData()[0].getStyrke());




        //SuperHelt helt = new SuperHelt(aliasNavn,);


    }
}
