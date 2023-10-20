package br.com.paulo.people;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetPeopleList {

    public static String getInput() {
        System.out.println("\nInsira os dados (ex: Pedro-homem,Claudia-mulher,...):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        return input;
    }

    public static List<People> getPeopleList(String input) {
        String[] peopleArray = input.split(",");

        List<String> peopleList = Arrays.asList(peopleArray);

        People people = new People();
        peopleList.stream()
            .forEach(p -> {
                String[] person = p.split("-");

                String name = person[0];
                String gender = person[1];

                people.setName(name);
                people.setGender(gender);
            });

        return Arrays.asList(people);
    }
}
