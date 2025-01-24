package fr.group1.wiseman.info3a.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class VersionManagerTest {
    private VersionManagerImpl versionMgr;
    private Buffer buffer;
    private final String replacementString = "zygotic";
    private final int start = 4;
    private final int end = 7;
    private Buffer bufferComp;
    @BeforeEach
    void setUp() {
        this.versionMgr = new VersionManagerImpl();
        String testString = "Hello world !";
        this.buffer = new BufferImpl(testString);
        this.bufferComp = new BufferImpl(testString);
    }

    @Test
    void undo() {
        AtomicOperation op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);
        //System.out.println(this.buffer.getContent());
        //this.versionMgr.debugHistory();
        this.versionMgr.undo(this.buffer);
        //System.out.println(this.buffer.getContent());
        assertEquals(this.bufferComp.getContent(), this.buffer.getContent());
    }

    /**
     * Test to undo consecutive edits in the same version
     */
    @Test
    void undo2() {
        AtomicOperation op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);

        op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);

        //this.versionMgr.debugHistory();
        this.versionMgr.undo(this.buffer);
        assertEquals(this.bufferComp.getContent(), this.buffer.getContent());
    }

    /**
     * Testing the result of 2 undos for 2 different versions
     * @throws InterruptedException if interrupted in the delay
     */
    @Test
    void undo3() throws InterruptedException {
        AtomicOperation op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);
        //System.out.println(this.buffer.getContent());

        TimeUnit.SECONDS.sleep(1);
        op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);
        //System.out.println(this.buffer.getContent());

        this.versionMgr.debugHistory();
        this.versionMgr.undo(this.buffer);
        //System.out.println(this.buffer.getContent());
        //this.versionMgr.debugHistory();
        this.versionMgr.undo(this.buffer);
        //System.out.println(this.buffer.getContent());
        assertEquals(this.bufferComp.getContent(), this.buffer.getContent());

    }

    /**
     * Testing for behaviour when too much undos compared to history size
     */
    @Test
    void undo4() {
        AtomicOperation op = new AtomicOperationImpl(buffer, this.start, this.end, this.replacementString);
        op.apply(buffer);
        this.versionMgr.addOperation(op);

        //this.versionMgr.debugHistory();
        this.versionMgr.undo(this.buffer);
        this.versionMgr.undo(this.buffer);

        assertEquals(this.bufferComp.getContent(), this.buffer.getContent());
    }

    @Test
    void addOperation() {
    }

}