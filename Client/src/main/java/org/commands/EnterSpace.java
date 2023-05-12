package org.client.commands;

import org.client.ClientStuff.ConsoleWriter;


import java.util.Scanner;

public class EnterSpace {
    Scanner scanner = new Scanner(System.in);
    ConsoleWriter consoleWriter = new ConsoleWriter();

    public String enterString(String name) {
        consoleWriter.printToConsole("Enter " + name + ":");
        return scanner.nextLine();

    }

    public Double enterDouble(String name) {
        Double result;
        while (true) {
            consoleWriter.printToConsole("Enter " + name + ":");
            try {
                String entered_field = scanner.nextLine();
                result = Double.parseDouble(entered_field);
                break;
            } catch (NumberFormatException e) {
                consoleWriter.printToConsole("Double data type required.");
            }
        }
        return result;
    }

    public float enterFloat(String name) {
        float result;
        while (true) {
            consoleWriter.printToConsole("Enter " + name + ":");
            try {
                String entered_field = scanner.nextLine();
                result = Float.parseFloat(entered_field);
                break;
            } catch (NumberFormatException e) {
                consoleWriter.printToConsole("Float data type required.");
            }
        }
        return result;
    }
}