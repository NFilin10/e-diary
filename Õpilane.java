import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;


public class Õpilane {
    private String eesnimi;
    private String perenimi;

    private String aine;

    private ArrayList<Integer> hinded;

    public Õpilane(){};

    public Õpilane(String eesnimi, String perenimi, ArrayList hinded, String aine) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.hinded = hinded;
        this.aine = aine;
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

    public String getAine() {
        return aine;
    }

    public void vaataHindeid(ArrayList<Klass> klassid, String õpilasePerenimi, String õpilaseKlass, String valitudAine){
        stop:
        for (Klass klass : klassid) {
            if (klass.getKlassiNumber().equals(õpilaseKlass) && klass.getAine().equals(valitudAine)){
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    if (õpilane.getPerenimi().equals(õpilasePerenimi)){
                        for (int hinne : õpilane.getHinded()) {
                            if (õpilane.getHinded().isEmpty()){
                                System.out.println("Hindeid pole");
                                break stop;
                            }
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
            if (klass.getKlassiNumber().equals(õpilaseKlass)) {
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
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

    public void õpilaseKeskmineHinned(ArrayList<Klass> klassid, String õpilasePerenimi, String õpilaseKlass, String valitudAine){
        for (Klass klass : klassid) {
            if (klass.getKlassiNumber().equals(õpilaseKlass) && klass.getAine().equals(valitudAine)) {
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    int summa = 0;
                    if (õpilane.getPerenimi().equals(õpilasePerenimi)){
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
