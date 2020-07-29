package com.hemebiotech.reformat;

import java.util.LinkedHashMap;

/**
 * Anything that will reformat the structure of the symptoms
 * The symptoms will be sort and we will get how many occurrence have each
 * We will put them into a LinkedHashMap to remove the duplicates
 *
 */
public interface ISymptomsReformat {

    void Sort();
    /**
     *
     * @return a LinkedHashMap with sorted and classified data by occurrences that will be used to write the symptoms in a file in the WriteSymptomsInFile class
     */
    LinkedHashMap<String, Integer> GetOccurrences();
}