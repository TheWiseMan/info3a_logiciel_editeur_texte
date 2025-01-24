package fr.group1.wiseman.info3a.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtomicOperationTest {
    private final String replacementString = "zygomatic";
    private final int start = 4;
    private final int end = 7;
    private Buffer buffer;
    private Buffer bufferComp;
    private AtomicOperation operation;
    @BeforeEach
    void setup() {
        String testString = "Hello world !";
        this.buffer = new BufferImpl(testString);
        this.bufferComp = new BufferImpl(testString);
        this.operation = new AtomicOperationImpl(this.buffer, this.start, this.end, this.replacementString);
    }
    @Test
    void apply() {
        this.operation.apply(this.buffer);
        this.bufferComp.setRange(this.start, this.end, this.replacementString);
        assertEquals(this.buffer.getContent(), this.bufferComp.getContent());
    }

    @Test
    void reverse() {
        this.operation.apply(this.buffer);
        AtomicOperation rev = this.operation.reverse();
        rev.apply(this.buffer);
        assertEquals(this.buffer.getContent(), this.bufferComp.getContent());
    }
}