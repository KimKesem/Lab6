package org.client.ClientStuff;

import org.client.commands.EnterSpace;
import java.util.Scanner;
public class ClientThing {
    private String name;
    private String passportID;
    private Double x;
    private float y;
    private Double height;
    private float weight;
    private String HairColor;

    public void putData(Object... o) {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        Scanner scanner = new Scanner(System.in);
        EnterSpace enterSpace = new EnterSpace();
        String name = enterSpace.enterString("name");
        String passportID = enterSpace.enterString("Passport");
        Double x = enterSpace.enterDouble("coordinates x");
        float y = enterSpace.enterFloat("coordinates y");
        Double height = enterSpace.enterDouble("height");
        float weight = enterSpace.enterFloat("weight");
        String HairColor = enterSpace.enterString("HairColor (GREEN, BLACK, BLUE, WHITE)");

        while (true) {
            try {
                HairColor.valueOf(HairColor);
                break;
            } catch (IllegalArgumentException e) {
                consoleWriter.printToConsole("No such value.");
                HairColor = enterSpace.enterString("HairColor (GREEN, BLACK, BLUE, WHITE)");
            }
        }



        this.name = name;
        this.passportID=passportID;
        this.x = x;
        this.y = y;
        this.height = height;
        this.weight = weight;
        this.HairColor = HairColor;
    }

    public String getName() {
        return name;
    }
    public String getPassportID(){return  passportID;}
    public Double getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public String getHairColor() {
        return HairColor;
    }
    public Double getHeight() {
        return height;
    }
    public float getWeight() {
        return weight;
    }

}
