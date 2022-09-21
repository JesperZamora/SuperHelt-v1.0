import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Superhelt> superhelteData = new ArrayList<Superhelt>();

    public void tilføjSuperhelt(String aliasNavn, String superNavn, int oprindelsesÅr, boolean menneske, String superkraft, double styrke) {

        Superhelt superhelt = new Superhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);
        superhelteData.add(superhelt);

    }

    public ArrayList<Superhelt> getSuperhelteData() {
        return superhelteData;
    }


    public Superhelt findSuperhelt (String navn) {
        for (int i = 0; i <superhelteData.size(); i++) {
            if(superhelteData.get(i).getSuperNavn().equals(navn)) {
                return superhelteData.get(i);
            } else if (superhelteData.get(i).getSuperNavn().contains(navn)) {
                return superhelteData.get(i);
            } else if (superhelteData.get(i).getAliasNavn().equals(navn)) {
                return superhelteData.get(i);
            } else if (superhelteData.get(i).getAliasNavn().contains(navn)) {
                return superhelteData.get(i);
           // } else if (superhelteData.get(i).toString().contains(navn)) {
           //     return superhelteData.get(i);
            }
        }
        return null;
    }



}
