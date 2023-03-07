
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner menuInput = new Scanner(System.in);
        System.out.println("Choose ur role:\n1. Teacher\n2. Student");
        String choice = menuInput.nextLine();
        if (choice.equals("1")){
            System.out.println("Sisestage oma eesnimi");
            String eesnimi = menuInput.nextLine();
            System.out.println("Sisestage oma perenimi");
            String perenimi = menuInput.nextLine();
            Opetaja opetaja = new Opetaja(eesnimi, perenimi);

            System.out.println("Valige tegevus:\n1. Lisa opilane");
            String tegevus = menuInput.nextLine();
            if (tegevus.equals("1")){
                opetaja.lisaOpilane();
            }
        }
    }
}







