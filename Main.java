
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void õpetajaRoll(ArrayList<Klass> klassid, Õpetaja õpetaja){
        Scanner õpetajaRolliSisend = new Scanner(System.in);
        while (true) {
            System.out.println("Valige tegevus:\n1. Lisa uus klass\n2. Lisa hinne");
            String tegevus = õpetajaRolliSisend.nextLine();

            if (tegevus.equals("1")){
                õpetaja.moodustaGrupp();
            }

            else if (tegevus.equals("2")){
                õpetaja.lisaHinne(klassid);

            }
            else if (tegevus.equals("q")) break;
        }
    }


    public static void õpilaseRoll(ArrayList<Klass> klassid){
        Scanner õpilaseRolliSisend = new Scanner(System.in);
        System.out.println("Sisestage oma eesnimi");
        String õpilaseEesnimi = õpilaseRolliSisend.nextLine();
        System.out.println("Sisestage oma klass");
        String õpilaseKlass = õpilaseRolliSisend.nextLine();


        while (true){
            System.out.println("Valige tegevus:\n1. Vaata hinned");
            String tegevus = õpilaseRolliSisend.nextLine();
            if (tegevus.equals("q")) break;
            System.out.println("Sisesta mis tunni hindeid soovid vaadata");
            String valitudAine = õpilaseRolliSisend.nextLine();
            Õpilane otsitavÕpilane = new Õpilane();
            for (Klass klass : klassid) {
                if (klass.getAine().equals(valitudAine) && klass.getKlassiNumber().equals(õpilaseKlass)){
                    for (Õpilane õpilane : klass.getÕpilasteGrupp()) {
                        if (õpilane.getEesnimi().equals(õpilaseEesnimi)){
                            otsitavÕpilane = õpilane;
                        }
                    }
                }
            }
            if (tegevus.equals("1")) {
                otsitavÕpilane.vaataHindeid();
            }
        }
    }

    public static void main(String[] args) {
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







