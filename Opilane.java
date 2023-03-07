import java.util.ArrayList;

public class Opilane {
    private String eesnimi;
    private String perenimi;

    private ArrayList<Integer> hinded;

    public Opilane(String eesnimi, String perenimi, ArrayList hinded) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.hinded = hinded;
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }

    public ArrayList<Integer> getHinded() {
        return hinded;
    }
}
