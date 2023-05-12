package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class ChangeOrderOfHeights implements Comandable {
    static String name = "change_order_of_heights";
    private MapWrapper<Integer, Person> hashMap;
    public ChangeOrderOfHeights(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }


    @Override
    public String Description() {
        return "Shows new order of heights with descending order.\n" +
                "\"change_order_of_heights\"";
    }
}