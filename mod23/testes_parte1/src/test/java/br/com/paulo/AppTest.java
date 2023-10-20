package br.com.paulo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import br.com.paulo.people.GetPeopleList;
import br.com.paulo.people.People;

public class AppTest {

    @Test
    public void testMain() {
        String input = "Pedro-homem,Claudia-mulher";

        List<People> peopleList = GetPeopleList.getPeopleList(input);

        Map<String, String> map = peopleList.stream()
        .filter(p -> p.getGender().equals("mulher"))
        .collect(Collectors.toMap(People::getName, People::getGender));

        Assert.assertEquals(map, Map.of("Claudia", "mulher"));
    }

    @Test
    public void testMainNotEquals() {
        String input = "Pedro-homem,Claudia-mulher";

        List<People> peopleList = GetPeopleList.getPeopleList(input);

        Map<String, String> map = peopleList.stream()
        .filter(p -> p.getGender().equals("mulher"))
        .collect(Collectors.toMap(People::getName, People::getGender));

        Assert.assertNotEquals(map, Map.of("Pedro", "homem"));
    }
}
