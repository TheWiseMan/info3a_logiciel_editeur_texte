package fr.group1.wiseman.info3a.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BufferTest {
    private final String testString = "Hello world !";
    private Buffer buffer;
    @BeforeEach
    void setUp() {
        buffer = new BufferImpl(testString);
    }

    @Test
    void getContent() {
        assertEquals(testString, this.buffer.getContent());
    }

    @Test
    void getRange() {
        assertEquals(testString.substring(0,4), this.buffer.getRange(0, 4));
        assertEquals(testString.substring(2), this.buffer.getRange(2, testString.length()));
        assertEquals(testString.substring(2,8), this.buffer.getRange(2, 8));
        assertEquals(testString.substring(2, 4), this.buffer.getRange(4, 2));
        assertEquals(testString.substring(0, 4), this.buffer.getRange(-12, 4));
        assertEquals(testString.substring(4), this.buffer.getRange(4, 121856));
        assertEquals(testString.substring(0, 4), this.buffer.getRange(4, -12));
        assertEquals(testString.substring(4), this.buffer.getRange(12156321, 4));
    }

    @Test
    void setRange() {
        this.buffer.setRange(0, 4, "Cowboy");
        assertEquals("Cowboy" + testString.substring(4), this.buffer.getContent());
    }

    @Test
    void getBufferBeginIndex() {
    }

    @Test
    void getBufferEndIndex() {
    }
}