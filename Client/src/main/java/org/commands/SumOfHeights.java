package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;

public class SumOfHeights implements Comandable {
    static String name = "sum_of_heights";
    private MapWrapper<Integer, Person> hashMap;
    public SumOfHeights(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }


    @Override
    public String Description() {
        return "Shows height  sum of all elements .\n" +
                "sum_of_heights";
    }
}