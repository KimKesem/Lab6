package org.server.commands;

import org.server.BasicPerson.HairColor;
import org.server.BasicPerson.Coordinates;
import org.server.BasicPerson.Person;
import org.server.ServerStuff.*;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Add implements Comandable, ClientThing {
    static String name = "add";
    private MapWrapper<Integer, Person> hashMap;
    public Add(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }
    public static String getName() {
        return name;
    }
    @Override
    public CommandResult execute(Object... o) {

        RandomNum randomNum = new RandomNum();
        int id = randomNum.createRandomNum(hashMap);

        String inputString = Arrays.toString(o);
        String[] inputValues = inputString.substring(1, inputString.length() - 1).split(" ");
        String name = inputValues[0];
        Double x = Double.parseDouble(inputValues[1]);
        float y = Float.parseFloat(inputValues[2]);
        Double height = Double.parseDouble(inputValues[3]);
        float weight = Float.parseFloat(inputValues[4]);
        String passportID = inputValues[5];
        String hairColor = inputValues[6];

        Date creationDate = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
        hashMap.put(id, new Person(id, name, passportID, new Coordinates(x, y), creationDate, height, weight,
                 HairColor.valueOf(hairColor)));

        return new CommandResult("Model  = " + id + " added", true);
    }

    @Override
    public String Description() {
        return "Add new element with generated key.\n" +
                "\"add\"";
    }


}
