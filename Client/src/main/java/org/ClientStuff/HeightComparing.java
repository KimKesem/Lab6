package org.client.ClientStuff;

import java.util.Comparator;
import java.util.Map;

import org.client.BasicPerson.Person;

public class HeightComparing {
    public void sortByHeight(MapWrapper<Integer, Person> hashMap) {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Person>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> consoleWriter.printToConsole(entry.getKey() + " : " + entry.getValue().toString()));
    }
}