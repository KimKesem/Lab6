package org.server.ServerStuff;

public class ConsoleWriter {
    public void ConsoleDoBePrinting(CommandResult commandResult) {
        System.out.println(commandResult.getMessage());
    }
    public void printToConsole(String message) {
        System.out.println(message);
    }
}
