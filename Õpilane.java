import java.io.PrintWriter;
import java.util.ArrayList;

public class Õpilane {
    private String eesnimi;
    private String perenimi;

    private ArrayList<Integer> hinded;

    public Õpilane(String eesnimi, String perenimi, ArrayList hinded) {
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
        return this.hinded;
    }

    public void vaataHindeid(ArrayList<Klass> klassid, String õpilasePerenimi, String õpilaseKlass, String valitudAine){
        for (Klass klass : klassid) {
            //otsime sobilikku klassi
            if (klass.getKlassiNumber().equals(õpilaseKlass) && klass.getAine().equals(valitudAine)) {
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    //otsime sobilikku õpilast
                    if (õpilane.getPerenimi().equals(õpilasePerenimi)) {
                        for (int hinne : õpilane.getHinded()) {
                            System.out.println(hinne);
                        }
                    }
                }
            }
        }

    }

    public void hinnedFaili(ArrayList<Klass> klassid, String õpilasePerenimi, String õpilaseKlass) throws Exception{
        PrintWriter myWriter = new PrintWriter(õpilasePerenimi + ".txt", "UTF-8");
        for (Klass klass : klassid) {
            //otsime sobilikku klassi
                if (klass.getKlassiNumber().equals(õpilaseKlass)) {
                    for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                        //otsime sobilikku õpilast
                        if (õpilane.getPerenimi().equals(õpilasePerenimi)) {
                            myWriter.write(klass.getAine() + "\n");
                            for (int hinne : õpilane.getHinded()) {
                                myWriter.write(hinne + ", ");
                            }
                            myWriter.write("\n");
                        }
                    }
                }

        }
        myWriter.flush();
    }

    public void õpilaseKeskmineHinne(ArrayList<Klass> klassid, String õpilasePerenimi, String õpilaseKlass, String valitudAine){
        for (Klass klass : klassid) {
            if (klass.getKlassiNumber().equals(õpilaseKlass) && klass.getAine().equals(valitudAine)) {
                //arvutame keskmist hinnet
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    int summa = 0;
                    if (õpilane.getPerenimi().equals(õpilasePerenimi)){
                        //arvutame hinnete summat
                        for (int hinne : õpilane.getHinded()) {
                            summa+=hinne;
                        }
                        double keskmineHinne = (double) summa/ õpilane.getHinded().size();
                        System.out.println(keskmineHinne);
                    }
                }
            }
        }
    }
}
