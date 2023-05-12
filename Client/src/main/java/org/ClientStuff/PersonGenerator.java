package org.client.ClientStuff;
import org.client.BasicPerson.Coordinates;
import org.client.BasicPerson.HairColor;
import org.client.BasicPerson.Person;
import org.client.commands.EnterSpace;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class PersonGenerator {
    ConsoleWriter ConsoleWriter = new ConsoleWriter();
    public Person createPerson(Integer id) {
        EnterSpace enterSpace = new EnterSpace();
        String name = enterSpace.enterString("name");
        String passportID = enterSpace.enterString("PassportID");
        Double x = enterSpace.enterDouble("coordinates x");
        float y = enterSpace.enterFloat("coordinates y");
        Date creationDate = new Date(ThreadLocalRandom.current().nextInt());
        ConsoleWriter.printToConsole("creationDate generated on its own" + creationDate);

        Double height = enterSpace.enterDouble("height");
        float weight = enterSpace.enterFloat("weight");

        String HairColorString = enterSpace.enterString("Color (GREEN, BLACK, BLUE, WHITE)");
        String decision = "N";

        while (true) {
            try {
                HairColor.valueOf(HairColorString);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printToConsole("No such value.");
                HairColorString = enterSpace.enterString("Colors (GREEN, BLACK, BLUE, WHITE)");
            }
        }

        return new Person(id, name, passportID,new Coordinates(x, y), creationDate, height, weight, HairColor.valueOf(HairColorString));

    }
}