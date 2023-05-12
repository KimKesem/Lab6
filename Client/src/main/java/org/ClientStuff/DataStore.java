package org.client.ClientStuff;

import java.util.Scanner;

public class DataStore {
    private String name;
    private Number value;
    public String getName() {
        return name;
    }

    public Number getValue() {
        return value;
    }
    public void putData(Object... o) {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        Scanner scanner = new Scanner(System.in);
        consoleWriter.printToConsole("Enter field name that you want to change (height/weight):");
        String name = scanner.nextLine();
        Number value = null;
        if (name.equals("height")) {
            consoleWriter.printToConsole("Enter new value:");
            try {
                value = scanner.nextDouble();
            } catch (Exception e) {
            }
        } else if (name.equals("weight")) {
            consoleWriter.printToConsole("Enter new value:");
            try {
                value = scanner.nextFloat();
            } catch (Exception e) {
            }
        }
        this.name = name;
        this.value = value;
    }


}