package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class PrintWeight implements Comandable {
    static String name = "print_unique_weight";
    private MapWrapper<Integer, Person> hashMap;
    public PrintWeight(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }



    @Override
    public String Description() {
        return "Prints unique values of weight field.\n" +
                "\"print_unique_weight\"";
    }

    public static String getName() {
        return name;
    }
}