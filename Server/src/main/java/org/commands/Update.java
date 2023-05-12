package org.server.commands;
import org.server.BasicPerson.Coordinates;
import org.server.BasicPerson.HairColor;
import org.server.BasicPerson.Person;
import org.server.ServerStuff.*;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class Update implements Comandable, IntArgument, ClientThing {
    static String name = "update";
    private MapWrapper<Integer, Person> hashMap;

    public Update(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    public static String getName() {
        return name;
    }


    @Override
    public CommandResult execute(Object... o) {

        String inputString = Arrays.toString(o);
        String[] inputValues = inputString.substring(1, inputString.length() - 1).split(" ");

        int id = Integer.parseInt(inputValues[0]);
        String name = inputValues[1];
        Double x = Double.parseDouble(inputValues[2]);
        float y = Float.parseFloat(inputValues[3]);
        Double height = Double.parseDouble(inputValues[4]);
        float weight = Float.parseFloat(inputValues[5]);
        String passportID = inputValues[6];
        String hairColor= inputValues[7];

        Date creationDate = new Date(ThreadLocalRandom.current().nextInt() * 1000L);


        CommandResult commandResult;
        if (hashMap.get(id) != null) {
            hashMap.put(id, new Person(id, name,passportID,  new Coordinates(x, y), creationDate, height, weight,
                    HairColor.valueOf(hairColor)));
            commandResult = new CommandResult("Person with id = " + id +
                    " replaced", true);
        } else {
            commandResult = new CommandResult("Person with id = " + id +
                    " does not exist!", false);
        }
        return commandResult;
    }
    @Override
    public String Description() {
        return "Update value of element in collection.\n" +
                "\"update {id}\"";
    }

}