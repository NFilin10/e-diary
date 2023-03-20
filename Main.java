
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void õpetajaRoll(ArrayList<Klass> klassid, Õpetaja õpetaja) throws Exception{
        Scanner õpetajaRolliSisend = new Scanner(System.in);
        while (true) {
            System.out.println("Valige tegevus:\n1. Lisa uus klass\n2. Lisa hinne\n3. Kuva klassid\n4. Kuva klassi nimekiri\n5. Vali suvalist õpilast\n6. Vaata klassi keskmist hinnet\nKuvaVäljumiseks sisestage 'q'");
            String tegevus = õpetajaRolliSisend.nextLine();

            if (tegevus.equals("1")){
                õpetaja.moodustaGrupp();
            } else if (tegevus.equals("2")){
                õpetaja.lisaHinne(klassid);
            } else if (tegevus.equals("3")) {
                õpetaja.kuvaKlassid(klassid);
            } else if (tegevus.equals("4")) {
                õpetaja.kuvaNimekiri(klassid);
            } else if (tegevus.equals("5")) {
                õpetaja.tahvliJuurde(klassid);
            } else if (tegevus.equals("6")) {
                õpetaja.aineKeskmineHinne(klassid);
            } else if (tegevus.equals("q")) break;
        }
    }


    public static void õpilaseRoll(ArrayList<Klass> klassid) throws Exception {
        Scanner õpilaseRolliSisend = new Scanner(System.in);
        System.out.println("Sisestage oma perenimi");
        String õpilasePerenimi = õpilaseRolliSisend.nextLine();
        System.out.println("Sisestage oma klass");
        String õpilaseKlass = õpilaseRolliSisend.nextLine();

        for (Klass klassKontroll : klassid) {
            if (klassKontroll.getKlassiNumber().equals(õpilaseKlass)){
                for (Õpilane õpilaseKontroll : klassKontroll.getÕpilasteGrupp()) {
                    if (õpilaseKontroll.getPerenimi().equals(õpilasePerenimi)){
                        while (true){
                            System.out.println("Valige tegevus:\n1. Vaata hinned\n2. Hinded faili\n3. Vaata keskmist hinnet\nVäljumiseks sisestage 'q'");
                            String tegevus = õpilaseRolliSisend.nextLine();
                            if (tegevus.equals("q")) break;
                            Õpilane otsitavÕpilane = new Õpilane();
                            if (tegevus.equals("2")) {
                                otsitavÕpilane.hinnedFaili(klassid, õpilasePerenimi, õpilaseKlass);
                                continue;
                            }
                            System.out.println("Sisesta mis tunni hindeid soovid vaadata");
                            String valitudAine = õpilaseRolliSisend.nextLine();
                            for (Klass klass : klassid) {
                                if (klass.getAine().equals(valitudAine) && klass.getKlassiNumber().equals(õpilaseKlass)){
                                    for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                                        if (õpilane.getPerenimi().equals(õpilasePerenimi)){
                                            otsitavÕpilane = õpilane;
                                        }
                                    }
                                }
                            }
                            if (tegevus.equals("1")) {
                                otsitavÕpilane.vaataHindeid(klassid, õpilasePerenimi, õpilaseKlass, valitudAine);
                            } else if (tegevus.equals("3")) {
                                otsitavÕpilane.õpilaseKeskmineHinned(klassid, õpilasePerenimi, õpilaseKlass, valitudAine);
                            }
                        }
                    }
                    else{
                        System.out.println("Sellist õpilast ei ole");
                    }
                }
            }
            else{
                System.out.println("Sellist klassi ei ole");
            }
        }


    }

    public static void main(String[] args) throws Exception {
        Scanner menüüSisend = new Scanner(System.in);
        System.out.println("Hetkel ei ole ühtegi õpetajat, seega sisenen õpetajana");
        Scanner teacherInput = new Scanner(System.in);
        System.out.println("Sisestage oma eesnimi");
        String õpetajaEesnimi = teacherInput.nextLine();
        System.out.println("Sisestage oma perenimi");
        String õpetajaPerenimi = teacherInput.nextLine();
        Õpetaja õpetaja = new Õpetaja(õpetajaEesnimi, õpetajaPerenimi);
        System.out.println("Esmalt peate lisama õpilasi");
        ArrayList<Klass> klassid = õpetaja.moodustaGrupp();

        õpetajaRoll(klassid, õpetaja);

        while (true) {
            System.out.println("Valike sisenemis viis:\n1. Õpetaja\n2. Õpilane");
            String valik = menüüSisend.nextLine();
            if (valik.equals("1")) {
                õpetajaRoll(klassid, õpetaja);

            }
            else if (valik.equals("2")) {
                õpilaseRoll(klassid);
            }
        }
    }
}







