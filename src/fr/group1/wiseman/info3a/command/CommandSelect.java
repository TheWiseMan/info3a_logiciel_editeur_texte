package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.Engine;

public class CommandSelect implements Command {
    Engine receiver;
    public CommandSelect(Engine receiver) {
        this.receiver=receiver;
    }

    @Override
    public void execute() {
    }
}
