package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.ServerStuff.HeightComparing;
import org.server.BasicPerson.Person;


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
    public CommandResult execute(Object... id) {
        HeightComparing heightComparing = new HeightComparing();
        String res = heightComparing.HeightComparing(hashMap);
        return new CommandResult(res + "\nCollection has been shown.", true);
    }


    @Override
    public String Description() {
        return "Shows all elements of collection.\n" +
                "\"show\"";
    }
}