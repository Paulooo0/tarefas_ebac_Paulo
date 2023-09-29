import java.util.Arrays;
import java.util.Scanner;

public class ReadName {
    public static void main(String[] args) {
        String names = getNames();
        splitNames(names);
    }

    private static String getNames() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite os nomes separados por virgula\n");
        String names = s.nextLine();

        return names;
    }

    private static void splitNames(String names) {
        String[] namesArray = names.split(",");
        Arrays.sort(namesArray);

        System.out.println("\n***************************");
        Arrays.stream(namesArray).forEach(System.out::println);
        System.out.println("***************************");
    }
}
