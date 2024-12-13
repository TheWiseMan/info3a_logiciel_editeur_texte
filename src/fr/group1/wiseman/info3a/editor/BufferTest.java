package fr.group1.wiseman.info3a.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BufferTest {
    private final String testString = "Hello world !";
    private final int arbitrarilyBigNumber = 12156321;
    private Buffer buffer;

    @BeforeEach
    void setUp() {
        buffer = new BufferImpl(testString);
    }

    @Test
    void getContent() {
        assertEquals(testString, this.buffer.getContent());
    }

    /**
     * beginIndex == 0; endIndex == 4; (normal use)
     */
    @Test
    void getRange1() {
        assertEquals(testString.substring(0, 4), this.buffer.getRange(0, 4));
    }

    /**
     * beginIndex == 2; endIndex == length;
     */
    @Test
    void getRange2() {
        assertEquals(testString.substring(2), this.buffer.getRange(2, testString.length()));
    }
    @Test
    void getRange3() {
        assertEquals(testString.substring(2, 8), this.buffer.getRange(2, 8));
    }

    /**
     * beginIndex > endIndex
     */
    @Test
    void getRange4() {
        assertEquals(testString.substring(2, 4), this.buffer.getRange(4, 2));
    }

    /**
     * beginIndex < 0
     */
    @Test
    void getRange5() {
        assertEquals(testString.substring(0, 4), this.buffer.getRange(-12, 4));
    }

    /**
     * endIndex >> length
     */
    @Test
    void getRange6() {
        assertEquals(testString.substring(4), this.buffer.getRange(4, this.arbitrarilyBigNumber));
    }

    /**
     * endIndex < 0
     */
    @Test
    void getRange7() {
        assertEquals(testString.substring(0, 4), this.buffer.getRange(4, -12));
    }

    /**
     * beginIndex >> length
     */
    @Test
    void getRange8() {
        assertEquals(testString.substring(4), this.buffer.getRange(this.arbitrarilyBigNumber, 4));
    }

    /**
     * beginIndex >> length; endIndex >> length
     */
    @Test
    void getRange9() {
        assertEquals("", this.buffer.getRange(this.arbitrarilyBigNumber, this.arbitrarilyBigNumber*7));
    }

    /**
     * beginIndex == endIndex
     */
    @Test
    void getRange10() {
        assertEquals("", this.buffer.getRange(7, 7));
    }

    /**
     * beginIndex == 0; endIndex == 4
     */
    @Test
    void setRange1() {
        this.buffer.setRange(0, 4, "Cowboy");
        assertEquals("Cowboy" + testString.substring(4), this.buffer.getContent());
    }

    /**
     * beginIndex > endIndex
     */
    @Test
    void setRange2() {
        this.buffer.setRange(4, 0, "Cowboy");
        assertEquals("Cowboy" + testString.substring(4), this.buffer.getContent());
    }

    /**
     * beginIndex < 0
     */
    @Test
    void setRange3() {
        this.buffer.setRange(-12, 4, "Cowboy");
        assertEquals("Cowboy" + testString.substring(4), this.buffer.getContent());
    }

    /**
     * endIndex < 0
     */
    @Test
    void setRange4() {
        this.buffer.setRange(0, -12, "Cowboy");
        assertEquals("Cowboy" + testString, this.buffer.getContent());
    }

    /**
     * startIndex >> length
     */
    @Test
    void setRange5() {
        this.buffer.setRange(this.arbitrarilyBigNumber, 4, "Cowboy");
        assertEquals(testString.substring(0, 4) + "Cowboy", this.buffer.getContent());
    }

    /**
     * startIndex >> length
     */
    @Test
    void setRange6() {
        this.buffer.setRange(4, this.arbitrarilyBigNumber, "Cowboy");
        assertEquals(testString.substring(0, 4) + "Cowboy", this.buffer.getContent());
    }

    @Test
    void getBufferBeginIndex() {
        assertEquals(0, this.buffer.getBufferBeginIndex());
    }

    @Test
    void getBufferEndIndex() {
        assertEquals(this.buffer.getContent().length(), this.buffer.getBufferEndIndex());
    }
}