package fr.group1.wiseman.info3a.editor;

public interface Buffer {
    String getContent();

    /**
     * Returns the string between two indexes
     * @param start the start index of the range to return
     * @param end the end index of the range to return
     * @return the string that is contained between start and end
     */
    String getRange(int start, int end);

    /**
     * Changes the string between two indexes
     * @param start the start index of the range to change
     * @param end the end index of the range to change
     * @param newContent the new content to insert
     * @throws IndexOutOfBoundsException if either parameters are out of bounds
     */
    void setRange(int start, int end, String newContent);

    /**
     * Provides the index of the first character in the buffer
     * @return the buffer start index
     */
    int getBufferBeginIndex();

    /**
     * Provides the index of the first "virtual" character
     * after the end of the buffer
     * @return the buffer end index
     */
    int getBufferEndIndex();
}
