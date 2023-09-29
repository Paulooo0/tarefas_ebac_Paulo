import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadNamesAndGender {
    public static void main(String[] args) {
        String namesAndGenders = getNamesAndGenders();
        splitGenderGroup(namesAndGenders);
    }

    private static String getNamesAndGenders() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite os nomes e generos (nome-genero), separados por virgula\n");
        String namesAndGenders = s.nextLine();

        return namesAndGenders;
    }

    public static void splitGenderGroup(String namesAndGenders) {
        String[] namesAndGendersArray = namesAndGenders.split(",");

        List<String> male = new ArrayList<>();
        List<String> female = new ArrayList<>();

        for (int i = 0; i < namesAndGendersArray.length; i++) {
            String[] gendersArray = namesAndGendersArray[i].split("-");
            String name = gendersArray[0];
            String gender = gendersArray[1];

            if (gender.startsWith("m")) {
                male.add(name);
            } else if (gender.startsWith("f")) {
                female.add(name);
            }
        }

        System.out.println("\nHomens: " + male.toString().replace("[", "").replace("]", ""));
        System.out.println("Mulheres: " + female.toString().replace("[", "").replace("]", ""));
    }
}
