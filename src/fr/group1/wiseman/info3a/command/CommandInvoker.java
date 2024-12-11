package fr.group1.wiseman.info3a.command;

import java.io.InputStream;

public interface CommandInvoker {
    /**
     * Starts the reading of the read stream set by setReadStream operation
     */
    void runInvokerLoop();

    /**
     * Stops the read stream loop now.
     */
    void stopLoop();

    /**
     * Sets the read stream that be be used by runInvokerLoop
     *
     * @param inputStream the read stream
     * @throws IllegalArgumentException if inputStream is null
     */
    void setReadStream(InputStream inputStream);


    /**
     * Registers a new keyword/command pair
     *
     * @param keyword a non-null String
     * @param cmd     a non-null Command reference
     * @throws java.lang.IllegalArgumentException for null parameters
     */
    void addCommand(String keyword, Command cmd);
}