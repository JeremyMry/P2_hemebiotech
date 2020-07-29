package com.hemebiotech.reader;

import com.hemebiotech.reformat.ReformatSymptomsData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadSymptomsDataFromFile implements ISymptomsReader {

    private String filepath;
    private List<String> symptoms;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     * @param symptoms a List that contains all the symptoms that has been read
     */
    public ReadSymptomsDataFromFile(String filepath, List<String> symptoms) {
        /**
         * @see ReadSymptomsDataFromFile#GetSymptoms()
         * @see ReformatSymptomsData#Sort()
         */
        this.filepath = filepath;
        /**
         * @see ReadSymptomsDataFromFile#GetSymptoms()
         */
        this.symptoms = symptoms;
    }

    /**
     * Read the txt file and put the content into a List
     * If the List is empty wich means the txt file is empty, quit the program
     * @see ReadSymptomsDataFromFile#filepath
     * @see ReadSymptomsDataFromFile#symptoms
     */
    @Override
    public List<String> GetSymptoms() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();

            while (line != null) {
                symptoms.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        if (symptoms.isEmpty()) {
            System.out.println("The txt file is empty !");
            System.exit(1);
        }
        return symptoms;
    }
}