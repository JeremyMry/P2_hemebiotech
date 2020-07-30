package com.hemebiotech.launcher;

import com.hemebiotech.reader.ISymptomsReader;
import com.hemebiotech.reader.ReadSymptomsDataFromFile;
import com.hemebiotech.reformat.ISymptomsReformat;
import com.hemebiotech.reformat.ReformatSymptomsData;
import com.hemebiotech.writer.ISymptomsWriter;
import com.hemebiotech.writer.WriteSymptomsInFile;

import java.io.IOException;
import java.util.*;

public class AnalyticsCounterLauncher {

    public static void main(String[] args) {

        try {
            /**
             * @see ReadSymptomsDataFromFile#GetSymptoms()
             * @see ReformatSymptomsData#Sort()
             */
            List<String> symptoms = new ArrayList<>();
            /**
             * @see ReformatSymptomsData#GetOccurrences()
             * @see WriteSymptomsInFile#WriteInFile()
             */
            Map<String, Integer> occurrences = new LinkedHashMap();

            ISymptomsReader reader = new ReadSymptomsDataFromFile("files/base_files/symptoms.txt", symptoms);
            reader.GetSymptoms();


            ISymptomsReformat reformat = new ReformatSymptomsData(symptoms, occurrences);
            reformat.Sort();
            reformat.GetOccurrences();

            ISymptomsWriter write = new WriteSymptomsInFile(occurrences, "files/results/","results.out");
            write.WriteInFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}