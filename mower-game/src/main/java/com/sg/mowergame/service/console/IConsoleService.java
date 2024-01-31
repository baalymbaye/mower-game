package com.sg.mowergame.service.console;

public interface IConsoleService {
    /**
     * Allow to read from the console
     * @return
     */
    String read();

    /**
     * Allow to write to the console
     * @param message
     */
    void write(final String message);

    /**
     * Allow to feed line
     */
    void lineFeed();

    /**
     * Allow to close <<scanner>>
     */
    void close();
}
