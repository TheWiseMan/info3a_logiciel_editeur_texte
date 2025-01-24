package fr.group1.wiseman.info3a.editor;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class VersionManagerImpl implements VersionManager {
    private final SortedMap<String, Vector<AtomicOperation>> bufferOperations = new TreeMap<>();

    @Override
    public void restoreVersion(Buffer buffer, String versionId) {
        for (String versionKey : this.bufferOperations.tailMap(versionId).keySet()) {
            Vector<AtomicOperation> ops = this.bufferOperations.get(versionKey);
            for (AtomicOperation op : ops.reversed()) {
                op.reverse().apply(buffer);
            }
            this.bufferOperations.remove(versionKey);
        }
    }

    @Override
    public void undo(Buffer buffer) {
        if (this.bufferOperations.isEmpty()) return;
        this.restoreVersion(buffer, this.bufferOperations.lastKey());
    }

    @Override
    public void addOperation(AtomicOperation op) {
        String t = Long.toHexString(System.currentTimeMillis());
        if (!this.bufferOperations.containsKey(t)) {
            this.bufferOperations.put(t, new Vector<>());
        }
        this.bufferOperations.get(t).add(op);
    }

    @Override
    public void debugHistory() {
        for (String versionKey : this.bufferOperations.keySet()) {
            System.out.println(versionKey + ":" + this.bufferOperations.get(versionKey)); //Prints each answer using the same for loop
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (String versionKey : this.bufferOperations.keySet()) {
            out.append(versionKey).append(":").append(this.bufferOperations.get(versionKey)).append("\n"); //Prints each answer using the same for loop
        }
        return out.toString();
    }
}
