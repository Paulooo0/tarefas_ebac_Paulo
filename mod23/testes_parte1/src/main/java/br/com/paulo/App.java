package br.com.paulo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.paulo.people.GetPeopleList;
import br.com.paulo.people.People;

public class App extends GetPeopleList {
    public static void main(String[] args) {
        String input = getInput();
        List<People> peopleList = getPeopleList(input);

        Map<String, String> map = peopleList.stream()
        .filter(p -> p.getGender().equals("mulher"))
        .collect(Collectors.toMap(People::getName, People::getGender));

        System.out.println("\nMulheres:");
        map.forEach((k, v) -> System.out.println(k));    
    }
}