
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Opetaja {
    private String eesnimi;
    private String perenimi;

    public ArrayList<Klass> k = new ArrayList<>();
    public Opetaja(String eesnimi, String perenimi) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
    }

    public ArrayList<Klass> lisaOpilane(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Sisestage klass: ");
        String klass = userInput.nextLine();
        System.out.println("Mitu ainet te soovite lisada selle klassi jaoks? ");
        int ainete_arv = userInput.nextInt();
        String[] ained = new String[ainete_arv];
        Scanner userInput1 = new Scanner(System.in);
        for (int i = 0; i < ainete_arv; i++) {
            System.out.println("Sisestage aine nimi: ");
            String aineNimi = userInput1.nextLine();
            ained[i] = aineNimi;
        }

        ArrayList<ArrayList<Opilane>> opilasteObjektidMax = new ArrayList<>(ainete_arv);

        System.out.println(opilasteObjektidMax);
        // [[[op1, op2], aine], [[op1, op2], aine]]

        Scanner userInput2 = new Scanner(System.in);
        int i = ainete_arv-1;
        while (true){
            System.out.println("Sisesta opilase eesnimi");
            String eesnimi = userInput2.nextLine();
            if (eesnimi.equals("q")) break;
            System.out.println("Sisesta opilase perenimi");
            String perenimi = userInput2.nextLine();
            if (perenimi.equals("q")) break;

            ArrayList<Integer> hinded = new ArrayList<>();


            while (i >= 0){
                opilasteObjektidMax.add(new ArrayList<>());
                i--;
            }


            for (int j = 0; j < ainete_arv; j++) {
                Opilane q = new Opilane(eesnimi, perenimi, hinded);
                opilasteObjektidMax.get(j).add(q);
            }
        }


        System.out.println(opilasteObjektidMax);

        Aine[] aineteKogum = new Aine[opilasteObjektidMax.size()];

        for (int j = 0; j < opilasteObjektidMax.size(); j++) {
            Aine aine = new Aine(ained[j], opilasteObjektidMax.get(j));
            aineteKogum[j] = aine;
        }

//        for (int j = 0; j < aineteKogum.length; j++) {
//            System.out.println(aineteKogum[j].aineNimi);
//            for (int k = 0; k < aineteKogum[j].opilasteGrupp.size(); k++) {
//                System.out.println(aineteKogum[j].opilasteGrupp.get(k).getEesnimi());
//
//            }
//
//        }
        Klass klassiLoomine = new Klass(klass, aineteKogum);
        k.add(klassiLoomine);
        for (Aine k : klassiLoomine.getAineteKogum()) {
            System.out.println(k.aineNimi);
            for (Opilane opilane : k.opilasteGrupp) {
                System.out.println(opilane.getEesnimi());
            }
            System.out.println("----------------------------");
        }

        System.out.println(k);

        return k;
    }

    public void lisaHinne(ArrayList<Klass> klassid){
        Scanner teacherInput1 = new Scanner(System.in);

        System.out.println("Vali klass kuhu soovid hinnet panna");
        String valitudKlass = teacherInput1.nextLine();
        System.out.println("Vali aine kuhu soovid hinnet panna");
        String valitudAine = teacherInput1.nextLine();
        System.out.println("Vali opilast kellele soovid hinnet panna");
        String valitOpilane = teacherInput1.nextLine();
        System.out.println("Sisesta hinne");
        int hinne = teacherInput1.nextInt();

        for (Klass klass : klassid) {
            if (klass.getKlass().equals(valitudKlass)){
                for (Aine aine : klass.getAineteKogum()) {
                    if (aine.aineNimi.equals(valitudAine)){
                        for (Opilane klass1 : aine.opilasteGrupp) {
                            if (klass1.getEesnimi().equals(valitOpilane)){
                                klass1.getHinded().add(hinne);
                            }
                        }
                    }


                }
            }

        }




//        System.out.println("Sisestage opilase nimi kellele soovite lisada hinnet");
//        String nimi = teacherInput.nextLine();
//        System.out.println("Sisestage aine nimi kuhu soovite lisada hinnet");
//        String aineNimi = teacherInput.nextLine();
//        for (Aine aine : opilased) {
//            for (Opilane opilane : aine.opilasteGrupp) {
//                if (aine.aineNimi.equals(aineNimi) && opilane.getEesnimi().equals(nimi)){
//                    opilane.getHinded().add(5);
//                }
//            }
//        }

    }

}
