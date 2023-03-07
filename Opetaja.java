
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Opetaja {
    private String eesnimi;
    private String perenimi;

    public Opetaja(String eesnimi, String perenimi) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
    }

    public Aine[] lisaOpilane(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Mitu ainet te soovite lisada? ");
        int ainete_arv = userInput.nextInt();
        String[] ained = new String[ainete_arv];
        Scanner userInput1 = new Scanner(System.in);
        for (int i = 0; i < ainete_arv; i++) {
            System.out.println("Sisestage aine nimi: ");
            String aineNimi = userInput1.nextLine();
            ained[i] = aineNimi;
        }


        Opilane[][] opilasteObjektidMax = new Opilane[ainete_arv][40];


       // [[[op1, op2], aine], [[op1, op2], aine]]

        Scanner userInput2 = new Scanner(System.in);
        int i = 0;
        while (true){
            System.out.println("Sisesta opilase eesnimi");
            String eesnimi = userInput2.nextLine();
            if (eesnimi.equals("q")) break;
            System.out.println("Sisesta opilase perenimi");
            String perenimi = userInput2.nextLine();
            if (perenimi.equals("q")) break;

            ArrayList<Integer> hinded = new ArrayList<>();
            for (int j = 0; j < opilasteObjektidMax.length; j++) {
                Opilane q = new Opilane(eesnimi, perenimi, hinded);
                opilasteObjektidMax[j][i] = q;
            }
            i++;
        }

        System.out.println(Arrays.deepToString(opilasteObjektidMax));
        System.out.println(i);
        Opilane[][] opilasteObjektid = new Opilane[ainete_arv][];
        for (int j = 0; j < opilasteObjektidMax.length; j++) {
            opilasteObjektid[j] = Arrays.copyOfRange(opilasteObjektidMax[j],0, i);
        }


        Aine[] aineteKogum = new Aine[opilasteObjektid.length];

        for (int j = 0; j < opilasteObjektid.length; j++) {
            Aine aine = new Aine(ained[j], opilasteObjektid[j]);
            aineteKogum[j] = aine;
        }

        for (int j = 0; j < aineteKogum.length; j++) {
            System.out.println(aineteKogum[j].aineNimi);
            for (int k = 0; k < aineteKogum[j].opilasteGrupp.length; k++) {
                System.out.println(aineteKogum[j].opilasteGrupp[k].getEesnimi());
            }

        }
        return aineteKogum;
    }

    public void lisaHinne(Aine[] opilased){
        Scanner teacherInput = new Scanner(System.in);
        System.out.println("Sisestage opilase nimi kellele soovite lisada hinnet");
        String nimi = teacherInput.nextLine();
        System.out.println("Sisestage aine nimi kuhu soovite lisada hinnet");
        String aineNimi = teacherInput.nextLine();
        for (Aine aine : opilased) {
            for (Opilane opilane : aine.opilasteGrupp) {
                if (aine.aineNimi.equals(aineNimi) && opilane.getEesnimi().equals(nimi)){
                    opilane.getHinded().add(5);
                }
            }
        }

    }

}
