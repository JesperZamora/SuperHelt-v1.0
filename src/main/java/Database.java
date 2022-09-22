import java.util.ArrayList;

public class Database {
    private ArrayList<Superhelt> superhelteData = new ArrayList<>();


    public void tilføjSuperhelt(String aliasNavn, String superNavn, int oprindelsesÅr, boolean menneske, String superkraft, double styrke) {

        Superhelt superhelt = new Superhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);
        superhelteData.add(superhelt);

    }

    public ArrayList<Superhelt> getSuperhelteData() {
        return superhelteData;
    }


    public ArrayList<Superhelt> findSuperhelt (String navn) {
        ArrayList<Superhelt> superhelte = new ArrayList<>();

        for (Superhelt superhelt : superhelteData) {
            if(superhelt.getAliasNavn().contains(navn)) {
                superhelte.add(superhelt);
            }
        }
        return superhelte;

    }
    /* Test superhelte
    public Database(){

        superhelteData.add(new Superhelt("Malou", "Wolff", 1990, true, "lille", 1000));

        Superhelt s2 = new Superhelt("Osama", "Wolff", 1991, false, "lille", 1000);
        superhelteData.add(s2);

        Superhelt s3 = new Superhelt("Paul", "Wolff", 1992, false, "lille", 1000);
        Superhelt s4 = new Superhelt("Dennis", "Wolff", 1993, true, "lille", 1000);
        superhelteData.addAll(List.of(s3, s4));

    }

     */


}
