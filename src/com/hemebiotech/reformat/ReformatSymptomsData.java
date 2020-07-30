
package com.hemebiotech.reformat;

import com.hemebiotech.writer.WriteSymptomsInFile;

import java.util.*;

public class ReformatSymptomsData implements ISymptomsReformat {

    /**
     * @see ReformatSymptomsData#Sort()
     */
    private List<String> results;
    /**
     * @see ReformatSymptomsData#GetOccurrences()
     * @see WriteSymptomsInFile#WriteInFile()
     */
    private LinkedHashMap<String, Integer> occurrences;

    /**
     *
     * @param results a List that contains all the symptoms
     * @param occurrences a LinkedHashMap that contains all the symptoms in the good format
     */
    public ReformatSymptomsData(List<String> results, LinkedHashMap<String, Integer> occurrences) {
        this.results = results;
        this.occurrences = occurrences;
    }

    /**
     * Sort by alphabetical order the symptoms contain into the List with the Collections framework and the sort() method.
     * @see ReformatSymptomsData#results
     */
    @Override
    public void Sort() {
        Collections.sort(results);
    }

    /**
     * Put the symptoms from the List into a LinkedHashMap
     * The key is the symptom (it will remove the duplicated symptoms) and the value is the occurrence of this symptom
     * To get occurrences we use the Collections framework with the frequency() method.
     * @see ReformatSymptomsData#occurrences
     */
    @Override
    public LinkedHashMap<String, Integer> GetOccurrences() {
        results.forEach((s) -> occurrences.put(s, Collections.frequency(results, s)));
        return occurrences;
    }
}