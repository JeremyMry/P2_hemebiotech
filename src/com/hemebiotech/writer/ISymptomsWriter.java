
package com.hemebiotech.writer;

import java.io.IOException;

/**
 * Anything that will write the symptoms in a file.
 * The symptoms are already formated and classified.
 * We just put them from a LinkedHashMap into a file with the Writer object
 */

public interface ISymptomsWriter {

    void WriteInFile() throws IOException;
}