import java.util.ArrayList;

public class Klass {
    private String klassiNumber;

    private String aine;
    private ArrayList<Õpilane> õpilasteGrupp;


    public Klass(String klassiNumber, ArrayList<Õpilane> õpilasteGrupp, String aine) {
        this.klassiNumber = klassiNumber;
        this.õpilasteGrupp = õpilasteGrupp;
        this.aine = aine;

    }

    public String getKlassiNumber() {
        return klassiNumber;
    }

    public String getAine() {
        return aine;
    }

    public ArrayList<Õpilane> getÕpilasteGrupp() {
        return õpilasteGrupp;
    }

}
