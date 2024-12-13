package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.EngineImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandCutTest {
    EngineImpl receiver;
    CommandCut cmd;
    String testString = "Hello World !";
    @BeforeEach
    void setUp() {
        this.receiver = new EngineImpl(this.testString);
        this.cmd = new CommandCut(receiver);
        this.receiver.getSelection().setBeginIndex(4);
        this.receiver.getSelection().setEndIndex(7);
    }

    @Test
    void execute() {
        String select = this.receiver.getSelectedText();
        this.cmd.execute();
        assertEquals(select, this.receiver.getClipboardContents());
        assertEquals("", this.receiver.getSelectedText());
    }
}