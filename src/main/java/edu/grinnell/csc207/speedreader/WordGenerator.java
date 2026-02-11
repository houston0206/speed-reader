package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/** 
 * WordGenerator class: constructs and implements functions for a scanner reading
 * from a text file
 */
public class WordGenerator {
    public Scanner scan;
    private int wordCount;
    private int sentenceCount; 

    /** 
     * Constructs the wordGenerator
     * @param fileName a string used to load the text file to be read from
     */
    public WordGenerator(String filename) throws IOException{
        File declare = new File(filename);
        this.scan = new Scanner(declare) ;
    }

    /** 
     * Checks if there is a token remaining in the file
     * @return a boolean
     */
    public boolean hasNext() {
        if (this.scan.hasNext()){
            return true;
        }
        return false;
    }

    /** 
     * Returns the next token (word) in the file and updates the wordCount and 
     * sentenceCount variables accordingly.
     * @return the next word, if it exists
     */
    public String next() {
        if (this.scan.hasNext()){
            String word = this.scan.next();
            this.wordCount++;
            if (word.endsWith("?") || word.endsWith("!") || word.endsWith(".")){
                this.sentenceCount++;
            }
            return word;
        }
        return null;
    }

    /** 
     * Returns the private value for sentenceCount
     * @return the value of the sentenceCount field
     */
    public int getWordCount() {
        return wordCount;
    }

    /** 
     * Returns the private value for sentenceCount
     * @return the value of the sentenceCount field
     */
    public int getSentenceCount() {
        return sentenceCount;
    }
}
