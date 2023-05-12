package org.server.ServerStuff;

public interface Comandable {
    public CommandResult execute(Object... o) throws Exception;
    public String Description();
}