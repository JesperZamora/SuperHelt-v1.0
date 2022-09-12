public class Database {
    private Superhelt[] superheltData = new Superhelt[5];
    private int n = 0;


    //TODO: skal gennemgå denne metode igen. Så jeg forstår den 100%.
    public void tilføjSuperhelt(String aliasNavn, String superNavn, int oprindelsesÅr, boolean menneske, String superkraft, double styrke) {

        Superhelt superhelt = new Superhelt(aliasNavn, superNavn, oprindelsesÅr, menneske, superkraft, styrke);

        superheltData[n] = superhelt;
        n++;

    }

    public Superhelt[] getSuperheltData() {
        return superheltData;
    }





}
