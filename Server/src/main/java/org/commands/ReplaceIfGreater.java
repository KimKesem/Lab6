package org.server.commands;
import org.server.BasicPerson.Person;
import org.server.ServerStuff.*;

import java.util.Arrays;

public class ReplaceIfGreater implements Comandable, IntArgument, DataStore {
    static String name = "replace_if_greater";
    private MapWrapper<Integer, Person> hashMap;
    public ReplaceIfGreater (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    public CommandResult execute(Object... o) {
        String inputString = Arrays.toString(o);
        String[] inputValues = inputString.substring(1, inputString.length() - 1).split(" ");
        int id;
        try {
            id = Integer.parseInt(inputValues[0]);
        } catch (NumberFormatException e) {
            return new CommandResult("Wrong data type in argument.", false);
        }
        String field = inputValues[1];
        Number value;
        try {
            value = Double.parseDouble(inputValues[2]);
        } catch (NumberFormatException e) {
            return new CommandResult("Wrong data type.", false);
        }



        CommandResult commandResult;
        if (hashMap.get(id) != null) {
            if (field.equals("enginePower")) {
                Number enginePower = value;
                if (hashMap.get(id).getHeight() - enginePower.doubleValue() < 0) {
                    hashMap.get(id).setHeight(enginePower.doubleValue());
                    commandResult = new CommandResult("value of  Height has been changed", true);
                } else {
                    commandResult = new CommandResult("Value that tou entered" +
                            " is lower than already existed.\nis lower than already existed.", false);
                }
            } else if (field.equals("capacity")) {
                Number capacity =  value;
                if (hashMap.get(id).getWeight() - capacity.floatValue() < 0) {
                    hashMap.get(id).setWeight(capacity.floatValue());
                    commandResult = new CommandResult("Weight is changed", true);
                } else {
                    commandResult = new CommandResult("Value that tou entered" +
                            " is lower than already existed.\nis lower than already existed.", false);
                }
            } else {
                commandResult = new CommandResult("Wrong field entered.", false);
            }
        } else {
            commandResult = new CommandResult("Model with id = " + id + " does not exist", false);
        }
        return commandResult;
    }



    @Override
    public String Description() {
        return "Replace value by the key if its lower than the key.\n" +
                "\"replace_if_greater\"";
    }
    public static String getName() {
        return name;
    }
}

