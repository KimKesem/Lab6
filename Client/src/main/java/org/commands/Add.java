package org.client.commands;
import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;

public class Add implements Comandable {
    static String name = "add";
    public static String getName() {
        return name;
    }
    private MapWrapper<Integer, Person> hashMap;
    public Add(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public String Description() {
        return "Add new element with generated key.\n" +
                "\"add\"";
    }
}
