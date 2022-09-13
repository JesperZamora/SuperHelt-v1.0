import java.util.ArrayList;

public class Database {
    private ArrayList<Superhelt> superhelteData = new ArrayList();
    
    public void tilføjSuperhelt(String aliasNavn, String superNavn, int oprindelsesÅr, boolean menneske, String superkraft, double styrke) {

        Superhelt superhelt = new Superhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);
        superhelteData.add(superhelt);

    }
    public ArrayList<Superhelt> getSuperhelteData() {
        return superhelteData;
    }


}
