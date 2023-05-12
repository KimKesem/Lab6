
package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class Show implements Comandable {
    static String name = "show";
    private MapWrapper<Integer, Person> hashMap;
    public Show (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }
    public static String getName() {
        return name;
    }


    @Override
    public String Description() {
        return "Shows all elements of collection.\n" +
                "\"show\"";
    }
}