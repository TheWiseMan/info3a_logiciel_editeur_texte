package fr.group1.wiseman.info3a.command;

public class CommandExit implements Command {
    private final CommandInvoker receiver;
    public CommandExit(CommandInvoker receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.stopLoop();
    }
}
