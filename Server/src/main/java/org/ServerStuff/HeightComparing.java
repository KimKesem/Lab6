package org.server.ServerStuff;


import org.server.BasicPerson.Person;

import java.util.Comparator;
import java.util.Map;

public class HeightComparing {

    public String HeightComparing(MapWrapper<Integer, Person> hashMap) {
        StringBuilder resultBuilder = new StringBuilder();
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Person>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> resultBuilder.append(entry.getKey()).append(" : ").append(entry.getValue().toString()).append(System.lineSeparator()));

        String result = resultBuilder.toString();
        return result;
    }
}