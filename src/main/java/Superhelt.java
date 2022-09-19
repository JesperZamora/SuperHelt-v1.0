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

    public void setAliasNavn(String aliasNavn) {
        this.aliasNavn = aliasNavn;
    }

    public String getSuperNavn() {
        return superNavn;
    }

    public void setSuperNavn(String superNavn) {
       this.superNavn = superNavn;
    }

    public void setSuperkraft(String superkraft) {
        this.superkraft = superkraft;
    }

    public void setOprindelsesÅr(int oprindelsesÅr) {
        this.oprindelsesÅr = oprindelsesÅr;
    }

    public void setStyrke (int styrke) {
        this.styrke = styrke;
    }

    public void setMenneske(boolean menneske) {
        this.menneske = menneske;
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

    public String toString(){
        return "Aliasnavn: " + aliasNavn + "\n" +
                "Supernavn: "+ superNavn  + "\n" +
                "Superkraft: " + superkraft  + "\n" +
                "Menneske: " + menneske + "\n" +
                "OprindelsesÅr: " + oprindelsesÅr + "\n"+
                "Styrke: " + styrke;

    }

}
