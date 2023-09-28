import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListingExample {
    private static List<String> femaleList = new ArrayList<>();
    private static List<String> maleList = new ArrayList<>();

    public static void main(String[] args) {
        String answer = "";
        do {
            String[] profile = getProfile();
            separateBySex(profile);
            answer = getAnswer();
        } while (answer.equalsIgnoreCase("sim"));
        if (!answer.equalsIgnoreCase("sim")) {
            System.out.println("\n********************************************");
            System.out.println("\nLista de mulheres: " + femaleList);
            System.out.println("Lista de homens: " + maleList);
            System.out.println("\n********************************************");
        }
    }
    
    private static String getAnswer() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nDeseja continuar? (sim ou não)");

        return s.nextLine();
    }

    private static String[] getProfile() {
        System.out.println("\nNome: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();

        System.out.println("\nSexo: ");
        s = new Scanner(System.in);
        String sex = s.nextLine();

        
        return new String[] {name, sex};
    }

    private static void separateBySex(String[] profile) {
        String name = profile[0];
        String sex = profile[1];

        if (sex.equalsIgnoreCase("f") ||
        sex.equalsIgnoreCase("feminino") ||
        sex.equalsIgnoreCase("mulher")) {
            femaleList.add(name);
        } else if (sex.equalsIgnoreCase("m") ||
        sex.equalsIgnoreCase("masculino") ||
        sex.equalsIgnoreCase("homem")) {
            maleList.add(name);
        } else {
            System.out.println("Sexo inválido");
        }

        System.out.println("\nLista de mulheres: " + femaleList);
        System.out.println("Lista de homens: " + maleList);
    }
}