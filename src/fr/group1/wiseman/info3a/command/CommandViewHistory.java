package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.Engine;

public class CommandViewHistory implements Command {
    private final Engine receiver;
    public CommandViewHistory(Engine receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.seeHistory();
    }
}
