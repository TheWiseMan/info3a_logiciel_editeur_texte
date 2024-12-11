package fr.group1.wiseman.info3a.editor;

/**
 * Provides access to selection control operations
 * @author jdg (from plouzeau)
 * @version 0.1
 */
public interface Selection {
    /**
     * Provides the index of the first character
     * designated by the selection.
     * @return the start index
     */
    int getBeginIndex();

    /**
     * Provides the index of the first character
     * after the last character designated by the selection.
     * @return the end index
     */
    int getEndIndex();

    /**
     * Changes the value of the start index of the selection
     *
     * @param beginIndex the new start index of the selection
     * @throws IndexOutOfBoundsException if the beginIndex is out of bounds
     */
    void setBeginIndex(int beginIndex);

    /**
     * Changes the value of the end index of the selection
     *
     * @param endIndex the new end index of the selection
     * @throws IndexOutOfBoundsException if the endIndex is out of bounds
     */
    void setEndIndex(int endIndex);
}
