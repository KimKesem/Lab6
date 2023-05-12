package org.server.commands;

import org.server.BasicPerson.Person;
import org.server.ServerStuff.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteScript implements Comandable, StringArgument {
    static String name = "execute_script_file";
    private MapWrapper<Integer, Person> hashMap;
    static List<String> usedFiles = new ArrayList<>();
    public static String getName() {
        return name;
    }
    public ExecuteScript(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public CommandResult execute(Object... o) throws IOException {
        CommandResult commandResult = null;

        String f = Arrays.toString(o).replaceAll("]", "").substring(1);
        if (usedFiles.contains(f)) {
            return new CommandResult("There is recursion was found.", false);
        }
        usedFiles.add(f);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayOfInput = line.split(" ");
                CommandManager commandManager = new CommandManager(hashMap);
                commandManager.CommandsList();
                Interaction.runScript(commandManager.getCommands(),hashMap, arrayOfInput);
            }
            usedFiles.clear();
            String res = Interaction.returnScriptRes();
            commandResult = new CommandResult(res, true);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            commandResult = new CommandResult("File not found.", false);
        } catch (IOException e) {
            commandResult = new CommandResult("Error", false);
        } catch (Exception e) {
        }
        return commandResult;
    }



    @Override
    public String Description() {
        return "Doing your script from certain file.\n" +
                "\"execute_script_file\"";
    }


}