
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void opetaja(ArrayList<Klass> opilased, Opetaja opetaja){
        Scanner teacherInput = new Scanner(System.in);
        while (true) {
            System.out.println("Valige tegevus:\n1. Lisa uus klass\n2. Lisa hinne");
            String tegevus = teacherInput.nextLine();

            if (tegevus.equals("1")){
                opetaja.lisaOpilane();
            }

            if (tegevus.equals("2")){
                opetaja.lisaHinne(opilased);

            }
            else if (tegevus.equals("q")) break;
        }
    }


    public static void opilane(ArrayList<Klass> opilased){
        Scanner studentInput = new Scanner(System.in);
        System.out.println("Sisestage oma klass");
        String opilaseKlass = studentInput.nextLine();
        System.out.println("Sisestage oma eesnimi");
        String opilaseEesnimi = studentInput.nextLine();
        System.out.println("Valige tegevus:\n1. Vaata hinned");
        String tegevus = studentInput.nextLine();
        if (tegevus.equals("1")){
            System.out.println("Sisesta mis tunni hindeid soovid vaadata");
            String tund = studentInput.nextLine();

            for (Klass klass : opilased) {
                if (klass.getKlass().equals(opilaseKlass)) {
                    for (Aine aine : klass.getAineteKogum()) {
                        if (aine.aineNimi.equals(tund)) {
                            for (Opilane klass1 : aine.opilasteGrupp) {
                                if (klass1.getEesnimi().equals(opilaseEesnimi)) {
                                    System.out.println(klass1.getHinded());
                                }
                            }
                        }


                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner menuInput = new Scanner(System.in);
        System.out.println("Hetkel ei ole ühtegi õpetahat, seega sisenen õpetajana");
//        Aine[] opetaja = opetaja();
        Scanner teacherInput = new Scanner(System.in);
        System.out.println("Sisestage oma eesnimi");
        String eesnimi = teacherInput.nextLine();
        System.out.println("Sisestage oma perenimi");
        String perenimi = teacherInput.nextLine();
        Opetaja opetaja = new Opetaja(eesnimi, perenimi);
        System.out.println("Esmalt peate lisama õpilasi");
        ArrayList<Klass> opiliased = opetaja.lisaOpilane();

        opetaja(opiliased, opetaja);

        while (true) {
            System.out.println("Choose ur role:\n1. Teacher\n2. Student");
            String choice = menuInput.nextLine();
            if (choice.equals("1")) {
                opetaja(opiliased, opetaja);

            }
            else if (choice.equals("2")) {
                opilane(opiliased);
            }
        }
    }
}







