package org.server.ServerStuff;

public class CommandResult {
    private String message;
    private boolean ight;

    public CommandResult(String message, boolean ight) {
        this.message = message;
        this.ight= ight;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIght() {
        return ight;
    }
}