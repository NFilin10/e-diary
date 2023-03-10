import java.util.ArrayList;
import java.util.Scanner;

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
        return hinded;
    }

    public String getAine() {
        return aine;
    }

    public void vaataHindeid(){
        if (hinded.isEmpty()){
            System.out.println("hindeid pole");
        } else {
            for (Integer hinne : hinded) {
                System.out.println(hinne);
            }
        }
    }

    public void hinnedFaili(){
        System.out.println(aine);
    }

    public void õpilaseKeskmineHinned(){
        //метод используя поле hinded выводит среднуюю оценку ученика
    }
}
