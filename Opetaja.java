
import java.util.Arrays;
import java.util.Scanner;

public class Opetaja {
    private String eesnimi;
    private String perenimi;

    public Opetaja(String eesnimi, String perenimi) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
    }

    public void lisaOpilane(){
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


        Scanner userInput2 = new Scanner(System.in);
        int i = 0;
        while (true){
            System.out.println("Sisesta opilase eesnimi");
            String eesnimi = userInput2.nextLine();
            if (eesnimi.equals("q")) break;
            System.out.println("Sisesta opilase perenimi");
            String perenimi = userInput2.nextLine();
            if (perenimi.equals("q")) break;

            for (int j = 0; j < opilasteObjektidMax.length; j++) {//1
                Opilane q = new Opilane(eesnimi, perenimi);
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


//        Opilane[][] opilasteObjektid = Arrays.copyOf(opilasteObjektidMax, i);

        for (Opilane[] opilanes : opilasteObjektid) {
            for (Opilane opilane : opilanes) {
                System.out.println(opilane.getEesnimi());
            }
            System.out.println("------------------------");
        }
    }
}
