package org.server.ServerStuff;

import org.server.commands.EnterSpace;
import org.server.BasicPerson.Coordinates;
import org.server.BasicPerson.HairColor;
import org.server.BasicPerson.Person;


import java.util.Date;

import java.util.concurrent.ThreadLocalRandom;

public class PersonGenerator {
    ConsoleWriter consoleWriter = new ConsoleWriter();
    public Person createPerson(Integer id) {
        EnterSpace enterSpace = new EnterSpace();
        String name = enterSpace.enterString("name");
        String passportID = enterSpace.enterString("PassportID");
        Double x = enterSpace.enterDouble("coordinates x");
        float y = enterSpace.enterFloat("coordinates y");

        Date creationDate = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
        consoleWriter.printToConsole("creationDate creates automatically:" + creationDate);

        Double height = enterSpace.enterDouble("height");
        float weight = enterSpace.enterFloat("weight");


        String HairColorString = enterSpace.enterString("Colors (GREEN, BLACK, BLUE, WHITE)");

        while (true) {
            try {
                HairColor.valueOf(HairColorString);
                break;
            } catch (IllegalArgumentException e) {
                consoleWriter.printToConsole("No such value.");
                HairColorString = enterSpace.enterString("Colors (GREEN, BLACK, BLUE, WHITE)");
            }
        }

        return new Person(id, name, passportID, new Coordinates(x, y), creationDate, height, weight,  HairColor.valueOf(HairColorString));

    }
}