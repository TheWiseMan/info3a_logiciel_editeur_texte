package fr.group1.wiseman.info3a.command;
/**
 * Defines a common interface for concrete commands.
 */
public interface Command {
    /**
     * Calls an appropriate operation on an appropriate receiver.
     * 'Appropriates' are defined in concrete implementation of Command.
     */
    void execute();
}
