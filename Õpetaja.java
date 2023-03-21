
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Õpetaja {
    private String eesnimi;
    private String perenimi;

    private ArrayList<Klass> klassid = new ArrayList<>();
    public Õpetaja(String eesnimi, String perenimi) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
    }

    public ArrayList<Klass> moodustaGrupp(){
        Scanner õpetajaSisendGrupp = new Scanner(System.in);
        System.out.println("Sisestage klass: ");
        String valitudKlass = õpetajaSisendGrupp.nextLine();
        System.out.println("Mitu ainet te soovite lisada selle klassi jaoks? ");
        int aineteArv = õpetajaSisendGrupp.nextInt();
        String[] aineteKogum = new String[aineteArv];
        Scanner userInput1 = new Scanner(System.in);
        for (int i = 0; i < aineteArv; i++) {
            System.out.println("Sisestage aine nimi: ");
            String aineNimi = userInput1.nextLine();
            aineteKogum[i] = aineNimi;
        }

        ArrayList<ArrayList<Õpilane>> õpilasteGrupp = new ArrayList<>(aineteArv);

        System.out.println(õpilasteGrupp);


        Scanner õpetajaSisendGrupp2 = new Scanner(System.in);
        int i = aineteArv-1;
        while (true){
            System.out.println("Sisesta opilase eesnimi\nLõpetamiseks sisestage 'q'");
            String õpilaseEesnimi = õpetajaSisendGrupp2.nextLine();
            if (õpilaseEesnimi.equals("q")) break;
            System.out.println("Sisesta opilase perenimi");
            String õpilasePerenimi = õpetajaSisendGrupp2.nextLine();
            if (õpilasePerenimi.equals("q")) break;


            while (i >= 0){
                õpilasteGrupp.add(new ArrayList<>());
                i--;
            }

            for (int j = 0; j < aineteArv; j++) {
                ArrayList<Integer> hinded = new ArrayList<>();
                Õpilane õpilane = new Õpilane(õpilaseEesnimi, õpilasePerenimi, hinded, aineteKogum[j]);
                õpilasteGrupp.get(j).add(õpilane);
            }
        }

        System.out.println(õpilasteGrupp);

        for (int j = 0; j < õpilasteGrupp.size(); j++) {
            Klass klass  = new Klass(valitudKlass, õpilasteGrupp.get(j), aineteKogum[j]);
            klassid.add(klass);
        }

        System.out.println(klassid);

        return klassid;
    }

    public void kuvaKlassid(ArrayList<Klass> klassid){
        for (Klass klass : klassid) {
            System.out.println(klass.getKlassiNumber());
        }
        System.out.println();
    }

    public void kuvaNimekiri(ArrayList<Klass> klassid){
        Scanner klassiValik = new Scanner(System.in);
        System.out.println("Vali klass");
        String valitudKlass = klassiValik.nextLine();

        for (Klass klass : klassid) {
            if (klass.getKlassiNumber().equals(valitudKlass)){
                int num = 1;
                System.out.println(klass.getKlassiNumber());
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    System.out.println(num + ". " + õpilane.getEesnimi() + " " + õpilane.getPerenimi());
                    num++;
                }
                System.out.println();
                break;
            }
            else{
                System.out.println("Sellist klassi ei ole");
            }
        }
    }

    public void lisaHinne(ArrayList<Klass> klassid){
        Scanner õpetajaSisendHinne = new Scanner(System.in);

        System.out.println("Vali klass kuhu soovid hinnet panna");
        String valitudKlass = õpetajaSisendHinne.nextLine();
        System.out.println("Vali aine kuhu soovid hinnet panna");
        String valitudAine = õpetajaSisendHinne.nextLine();

        while (true){
            Scanner õpetajaSisendHinne1 = new Scanner(System.in);
            System.out.println("Vali opilast kellele soovid hinnet panna\nLõpetamiseks sisestage 'q'");
            String valitudOpilane = õpetajaSisendHinne1.nextLine();
            if (valitudOpilane.equals("q")) break;
            System.out.println("Sisesta hinne");
            int hinne = õpetajaSisendHinne1.nextInt();

            stop:
            for (Klass klass : klassid) {
                if (klass.getAine().equals(valitudAine) && klass.getKlassiNumber().equals(valitudKlass)){
                    for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                        if (õpilane.getPerenimi().equals(valitudOpilane)){
                            õpilane.getHinded().add(hinne);
                            break stop;
                        }
                    }
                }
            }
        }

    }


    public void aineKeskmineHinne(ArrayList<Klass> klassid){
        Scanner õpetajaSisendHinne = new Scanner(System.in);

        System.out.println("Vali klass kuhu soovid hinnet panna");
        String valitudKlass = õpetajaSisendHinne.nextLine();
        System.out.println("Vali aine kuhu soovid hinnet panna");
        String valitudAine = õpetajaSisendHinne.nextLine();

        for (Klass klass : klassid) {
            if (klass.getAine().equals(valitudAine) && klass.getKlassiNumber().equals(valitudKlass)){
                int hinneteSumma = 0;
                int kokkuHindeid = 0;
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    kokkuHindeid += õpilane.getHinded().size();
                    for (int hinne : õpilane.getHinded()) {
                        hinneteSumma+=hinne;
                    }
                }
                double keskmineHinne = (double) hinneteSumma/kokkuHindeid;
                System.out.println(keskmineHinne);
                System.out.println();
                break;
            }
        }
    }


    public void tahvliJuurde(ArrayList<Klass> klassid){
        //спрашиваем в каком классе нужно рандомно вызвать ученика к доске
        //находим нужный класс, генерируем рандомное число исходя из количества учеников и принтуем имя и фамилию ученика
        // который находится под выпавшим номером
        Scanner õpilaneTahvliJuurde = new Scanner(System.in);

        System.out.println("Vali klass millest õpilane tuleb tahvli juurde ");
        String valitudKlass = õpilaneTahvliJuurde.nextLine();

        stop:
        for (Klass klass : klassid) {
            if (klass.getKlassiNumber().equals(valitudKlass)){
                int juhuslikOpilane = (int) ((Math.random() * (klass.getÕpilasteGrupp().size())));
                int loendur = 0;
                for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                    if (loendur == juhuslikOpilane){
                        System.out.println("Tahvli juurde läheb: " + õpilane.getEesnimi() + " " + õpilane.getPerenimi());
                        System.out.println();
                        break stop;
                    }
                    loendur++;
                }
            }
        }
    }
}

