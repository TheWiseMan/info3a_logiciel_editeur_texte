package fr.group1.wiseman.info3a.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EngineTest {
    private Engine engine;
    @BeforeEach
    void setup() {
        engine = new EngineImpl("Hello World !");
    }
    @Test
    void getSelection() {
        
    }

    @Test
    void getBufferContents() {
        assertEquals("Hello World !", engine.getBufferContents());
    }

    @Test
    void getClipboardContents() {
        //testing default clipboard
        assertEquals("", engine.getClipboardContents());

        //testing after selection and copy
        engine.getSelection().setBeginIndex(3);
        engine.getSelection().setEndIndex(7);
        engine.copySelectionText();
        assertEquals("lo W", engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
    }

    @Test
    void copySelectionText() {
    }

    @Test
    void pasteClipboard() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }
}