public class Superhelt {
    private String aliasNavn;
    private String superNavn;
    private int oprindelsesÅr;
    private boolean menneske;
    private String superkraft;
    private double styrke;

    public Superhelt(String aliasNavn, String superNavn, int oprindelsesÅr, boolean menneske, String superkraft, double styrke) {
        this.aliasNavn = aliasNavn;
        this.superNavn = superNavn;
        this.oprindelsesÅr = oprindelsesÅr;
        this.menneske = menneske;
        this.superkraft = superkraft;
        this.styrke = styrke;
    }


    public String getAliasNavn() {
        return aliasNavn;
    }

    public String getSuperNavn() {
        return superNavn;
    }

    public boolean getMenneske() {
        return menneske;
    }

    public int getOprindelsesÅr() {
        return oprindelsesÅr;
    }

    public String getSuperkraft() {
        return superkraft;
    }

    public double getStyrke() {
        return styrke;
    }


}
